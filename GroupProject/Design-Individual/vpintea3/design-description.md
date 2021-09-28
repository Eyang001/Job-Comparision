Name : Valentino Pintea. 
userID : vpintea3. 
Email : vpintea3@gatech.edu. 

Design Description

1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  
**-- It is expected that the GUI will render the main menu screen and act as the entry point into the application whereby the user will have buttons that provide the main functionality of the app. I have fulfilled requirement 1 within the MainMenu class as methods. These methods then rely on other classes to complete the necessary functionality such as: (1) CurrentJob class, (2) JobOffers class, (3) ComparisonSettings class and (4) CompareJobOffers class, respectively.**

2. When choosing to enter current job details, a user will:  
a. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:  
i. Title  
ii. Company  
iii. Location (entered as city and state)  
iv. Cost of living in the location (expressed as an index)  
v. Yearly salary  
vi. Yearly bonus  
vii. Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)  
viii. Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)  
ix. Gym membership allowance ($0 to $500 annually)   
**-- I have fulfilled the listed requirements in 2.a) by designing attributes within the Job class. It is expected that the GUI will render an interface for the user to input relevant information related to these attributes.**  

b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.  
**-- I have fulfilled the requirement in 2.b) by designing 2 methods within the CurrentJobManager class. It is expected that the GUI will handle the return back to the main menu by rendering the main menu screen.**
				
3. When choosing to enter job offers, a user will:	
a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.  
**-- I have fulfilled requirement 3.a) by designing a JobOffers class which holds a list of Job(s) and thereby the attributes of each Job (created from the Job class) can be accessed.**

b. Be able to either save the job offer details or cancel.  
**-- I have fulfilled requirement 3.b) by designing methods in the JobOffers class for saving and cancelling.**
 									
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).  
**-- I have fulfilled requirement 3.c) by designing methods in the JobOffer class for entering another offer, returning to main menu and comparing the offer with the current job**
 									
4. When adjusting the comparison settings, the user can assign integer weights to:  
 								
a. Yearly salary  
b. Yearly bonus  
c. Allowed weekly telework days  
d. Leave time  
e. Gym membership allowance  
**-- I have fulfilled requirements 4.a) to e) by designing a corresponding method within the ComparisonSettings class where the user can set customized integer weights that are different from the default value.**  

If no weights are assigned, all factors are considered equal.  
**-- I have fulfilled the above requirement by assigning a default value of integer 1 to the above Job attributes which effectively sets a weight of 1 to each attribute and thus all attributes are equally weighted (although any other number could have worked in this design as well).**  
 							
5. When choosing to compare job offers, a user will:  
 								
a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.  
**-- I have fulfilled requirement 5.a) by passing some of the work to be managed by the GUI. Specifically, the GUI will show the ranked list of job offers, including their Title and Company. The ranking and sorting will be performed by the rankJobOffers function within the CompareJobOffers class.**
 									
b. Select two jobs to compare and trigger the comparison.  
**-- I have fulfilled requirement 5.b) by having the GUI handle the task of providing and rendering for the user a list from which two jobs can be selected and compared.**. 
 									
c. Be shown a table comparing the two jobs, displaying, for each job:  
 										
i. Title  
ii. Company  
iii. Location  
iv. Yearly salary adjusted for cost of living  
v. Yearly bonus adjusted for cost of living  
vi. Allowed weekly telework days  
vii. Leave time  
viii. Gym Membership Allowance  
**-- I have fulfilled requirement 5.c) by handing the task of providing a comparison table to the GUI. This table would show the requested attributes above for the two Jobs.**  

d. Be offered to perform another comparison or go back to the main menu.  
**-- I have fulfilled requirement 5.d) by designing 2 methods within the JobOffersClass to compareJobs, which effectively performs another comparison,  and a return to the main menu.** 
 									
6. When ranking jobs, a job’s score is computed as the weighted sum of:  
 								
AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)  
 								
where:  
 AYS = yearly salary adjusted for cost of living  
 AYB = yearly bonus adjusted for cost of living  
 GYM = Gym Membership Allowance ($0 to $500 annually) LT = leave time  
 RWT = telework days per week  
 The rationale for the RWT subformula is:  
 								
a. value of an employee hour = (AYS / 260) / 8  
 									
b. commute hours per year (assuming a 1-hour/day commute) =  
1 * (260 - 52 * RWT)  
 									
c. therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8   
 									
For example, if the weights are 2 for the yearly salary, 2 for Gym Membership, and 1 for all other factors, the score would be computed as:  
2/7 * AYS + 1/7 * AYB + 2/7 * GYM + 1/7 * (LT * AYS / 260) - 1/7 * ((260 - 52 * RWT) * (AYS / 260) / 8)  
**-- Requirements 6.a), b), c) are implementation details not design specifications and thus they have not been directly represented in my UML diagram. However, the calculations are expected to be handled by the rankJobOffers method within the CompareJobOffers class.**  

7. The user interface must be intuitive and responsive.  
**-- Requirement 7 is implied to be incorporated through efficient code and is not a design specification and thus I have not directly represented it in my UML diagram.**   
 							
8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).  
**-- Requirement 8 is implied to be incorporated within the architecture but is not a design specification and thus it is not directly represented in my UML diagram.**
 							
