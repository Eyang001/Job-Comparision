1. When the app is started, the user is presented with the main menu, which allows the
user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison
settings, or (4) compare job offers (disabled if no job offers were entered yet).

Please refer to design.pdf, I created a User class with associations to classes that fulfill the listed requirements (1) through (4). 
User has attributes which will be checked to see if (4) will be enabled. 


2. When choosing to enter current job details, a user will:
a. Be shown a user interface to enter (if it is the first time) or edit all of the details of
their current job, which consist of:
i. Title
ii. Company
iii. Location (entered as city and state)
iv. Cost of living in the location (expressed as an index)
v. Yearly salary
vi. Yearly bonus
vii. Allowed weekly telework days (expressed as the number of days per
week allowed for remote work, inclusively between 0 and 5)
viii. Leave time (vacation days and holiday and/or sick leave, as a single
overall number of days)
ix. Gym membership allowance ($0 to $500 annually)
b. Be able to either save the job details or cancel and exit without saving, returning
in both cases to the main menu.

I created a CurrentJobDetails class which inherits from abstract Job class the attributes listed above in a.
The CurrentJobDetails class has methods, saveTheJobDetails() and cancelAndExitWithoutSaving(), which accomplish b.


3. When choosing to enter job offers, a user will:
a. Be shown a user interface to enter all of the details of the offer, which are the
same ones listed above for the current job.
b. Be able to either save the job offer details or cancel.
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the
offer (if they saved it) with the current job details (if present).

I created a JobOffers class which inherits from abstract Job class the attributes in a.
The methods, refer to design.pdf for list of methods, accomplish b. and c.


4. When adjusting the comparison settings, the user can assign integer weights to:
a. Yearly salary
b. Yearly bonus
c. Allowed weekly telework days
d. Leave time
e. Gym membership allowance
If no weights are assigned, all factors are considered equal.

ComparisonSettings class has attributes for each of the items listed above (a. through e.), which account for the weight of these items in integer form.
The attribtutes are all set to 1 originally, so that if they are not adjusted, they will all be equal weight.


5. When choosing to compare job offers, a user will:
a. Be shown a list of job offers, displayed as Title and Company, ranked from best
to worst (see below for details), and including the current job (if present), clearly
indicated.
b. Select two jobs to compare and trigger the comparison.
c. Be shown a table comparing the two jobs, displaying, for each job:
i. Title
ii. Company
iii. Location
iv. Yearly salary adjusted for cost of living
v. Yearly bonus adjusted for cost of living
vi. Allowed weekly telework days
vii. Leave time
viii. Gym Membership Allowance
d. Be offered to perform another comparison or go back to the main menu.

CompareJobOffers has methods which will display a ranked list of jobs to satisfy a.
CompareJobOffers class has attributes for two jobs which will be compared, this comparison will trigger the display of a table comparing the two jobs, satisfying b.
The table will be populated using the RankJob class (described below) to compute a job score for each job, and then list them in descending order of job score, satisfying c.
Methods, refer to design.pdf for details, are provided to satisfy d.


6. When ranking jobs, a job’s score is computed as the weighted sum of:
AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)
where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
GYM = Gym Membership Allowance ($0 to $500 annually)
LT = leave time
RWT = telework days per week
The rationale for the RWT subformula is:
a. value of an employee hour = (AYS / 260) / 8
b. commute hours per year (assuming a 1-hour/day commute) =
1 * (260 - 52 * RWT)
c. therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8
For example, if the weights are 2 for the yearly salary, 2 for Gym Membership, and 1 for
all other factors, the score would be computed as:
2/7 * AYS + 1/7 * AYB + 2/7 * GYM + 1/7 * (LT * AYS / 260) - 1/7 * ((260 - 52 * RWT) *
(AYS / 260) / 8)

RankJob class has attributes for all the items listed above, and a method to compute the job score, following the formula provided.


7. The user interface must be intuitive and responsive.

Will be handled by the GUI, not relevant in the design.pdf


8. For simplicity, you may assume there is a single system running the app (no
communication or saving between devices is necessary).

Assumed.
