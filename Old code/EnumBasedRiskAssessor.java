package edu.ipa.pandemic;

import java.util.List;

// NOTE: Of course this isn't any kind of official medical diagnosis machine.  Come on people I'm
//       just a programmer guy!  Don't base your covid-19 risk assessment on my nonsense please.
public class EnumBasedRiskAssessor implements IRiskAssessor
{
	@Override
	public RiskLevel assess(List<Symptom> symptoms, List<RiskModifier> riskModifiers)
	{
		RiskLevel level = RiskLevel.NON_URGENT;

		// If no travel, or no interaction with a traveller patients are not urgent
		boolean travel = false;
		for (int i = 0; i < riskModifiers.size(); i++)
		{
			switch (riskModifiers.get(i))
			{
				case INTERACTED_WITH_TRAVELLER:
				case TRAVELLED:
				{
					travel = true;
					break;
				}
			}
		}

		// Does the patient have every symptom?
		boolean f = false;
		boolean c = false;
		boolean db = false;
		boolean p = false;
		for (int i = 0; i < symptoms.size(); i++)
		{
			switch (symptoms.get(i))
			{
				case COUGH:
				{
					c = true;
					break;
				}
				case FEVER:
				{
					f = true;
					break;
				}
				case DIFFICULTY_BREATHING:
				{
					db = true;
					break;
				}
				case PNEUMONIA_IN_BOTH_LUNGS:
				{
					p = true;
					break;
				}
			}
		}
		if (f && c && db && p)
		{
			if (travel)
			{
				// If they travelled and have every symptom they are at the highest risk
				return RiskLevel.RESUSCITATION;
			}
			else
			{
				// If they have every symptom, it's dangerous but not critical.
				level = RiskLevel.URGENT;
			}
		}

		// Now I am going to make up some pretend scenarios:
		// - If the patient is pregnant and has a cough but no fever this is not urgent
		for (int i = 0; i < riskModifiers.size(); i++)
		{
			if (riskModifiers.get(i) == RiskModifier.PREGNANT)
			{
				if (c && !f)
				{
					return RiskLevel.LESS_URGENT;
				}
				break;
			}
		}
		// - If patient has HIV and travelled or interacted with a traveller they should be tested,
		//   if they have cough or fever it is critical.
		for (int i = 0; i < riskModifiers.size(); i++)
		{
			if (riskModifiers.get(i) == RiskModifier.HIV)
			{
				if (travel)
				{
					if (c || f)
					{
						return RiskLevel.EMERGENT;
					}
					else if (f && c && db && p)
					{
						return RiskLevel.RESUSCITATION;
					}
					else
					{
						return RiskLevel.URGENT;
					}
				}
				break;
			}
		}
		// - If patient is elderly, having 2 or more symptoms is equivalent to having all symptoms
		// - Having asthma is equivalent to being elderly in this scenario
		for (int i = 0; i < riskModifiers.size(); i++)
		{
			switch (riskModifiers.get(i))
			{
				case OLDER_THAN_65:
				case ASTHMA:
				{
					if (symptoms.size() >= 2)
					{
						if (travel)
						{
							return RiskLevel.RESUSCITATION;
						}
						else
						{
							level = RiskLevel.URGENT;
						}
					}
					break;
				}
			}
		}
		return level;
	}
}
