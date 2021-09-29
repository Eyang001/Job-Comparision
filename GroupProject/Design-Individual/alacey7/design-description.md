# Design Description

1.	When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

	__*The menu is not explicitly addressed as it is a feature of the GUI, but the system/controller supports all 4 of the menu’s options.*__

2.	When choosing to enter current job details, a user will:
	1.	Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
		1.	Title
		2.	Company
		3.	Location (entered as city and state)
		4.	Cost of living in the location (expressed as an index)
		5.	Yearly salary
		6.	Yearly bonus
		7.	Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)
		8.	Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)
		9.	Gym membership allowance ($0 to $500 annually)
	2.	Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

	__*The interface will be handled by the GUI. The Job class supports the Title, salary, bonus, telework days, and leave time. The Company class supports the company name, and the gym membership allowance; the gym membership is an attribute of the company because it is not unique to a job offer- but rather it is a benefit all employees are afforded. The Location class has a city and state attribute, and a cost-of-living index attribute. The Job class also includes a Company and Location attribute for enabling access to the attributes they contain that affect the job.*__


3. When choosing to enter job offers, a user will:
	1. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
	2. Be able to either save the job offer details or cancel.
	3. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

	__*The System Class keeps track of all job offers and will provide the functionality to enter and edit job offers.*__

4.	When adjusting the comparison settings, the user can assign integer weights to:
	a.	Yearly salary
	b.	Yearly bonus
	c.	Allowed weekly telework days
	d.	Leave time
	e.	Gym membership allowance
	f.	If no weights are assigned, all factors are considered equal.

	__*The System class tracks the weights for each of these factors via a ComparisonWeights class. The ComparisonWeights can be passed to an existing job to calculate its job score. This ensures that jobs don’t maintain an intrinsic score, so that scores can be recalculated every time the comparison settings are updated.*__

5.	When choosing to compare job offers, a user will:
	1.	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
	2.	Select two jobs to compare and trigger the comparison.
	3.	Be shown a table comparing the two jobs, displaying, for each job:
		1.	Title
		2.	Company
		3.	Location 
		4.	Yearly salary adjusted for cost of living
		5.	Yearly bonus adjusted for cost of living
		6.	Allowed weekly telework days
		7.	Leave time
		8.	Gym Membership Allowance
	4.	Be offered to perform another comparison or go back to the main menu.

	__*The System class enables two selected jobs to be compared via its compareOffers method. The System also maintains a map of jobs to job scores (updated when the Comparison Settings change) to support rank ordering of jobs as the scores change. Display of the comparison will be handled by the GUI.*__

6.	When ranking jobs, a job’s score is computed as the weighted sum of:
AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)
where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
GYM = Gym Membership Allowance ($0 to $500 annually)
LT = leave time
RWT = telework days per week
The rationale for the RWT subformula is:
	1. value of an employee hour = (AYS / 260) / 8
	2. commute hours per year (assuming a 1-hour/day commute) = 1 * (260 - 52 * RWT)
	3. therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8

	For example, if the weights are 2 for the yearly salary, 2 for Gym Membership, and 1 for all other factors, the score would be computed as:  
	2/7 * AYS + 1/7 * AYB + 2/7 * GYM + 1/7 * (LT * AYS / 260) - 1/7 * ((260 - 52 * RWT) * (AYS / 260) / 8)  
	
	__*The Job class has a getJobScore method that takes a ComparisonWeights object as an argument to compute the job’s score using the above formulas.*__

7.	The user interface must be intuitive and responsive.
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

	__*The GUI is not represented in the design, but the system is designed to utilize the Model-View-Controller pattern. This will enable intuitive Views to be built to display the relevant information.*__