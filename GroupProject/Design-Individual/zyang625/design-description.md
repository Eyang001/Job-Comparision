##Design Description

The user will be presented with the main menu once started the app. The user is allowed to: 
    1. enter or edit current job details
    2. enter job offers
    3. adjust current comparison settings
    4. compare job offers

The 'User' class will implement the actions above via _editCurJob_, _enterOffer_, _adjustSettings_ and _compare_.

1. When enter or _editCurJob_ is called, the user will be presented with an interface to enter or edit the current job details, including below: 
    * Title
    * Company
    * Location (entered as city and state)
    * Cost of living in the location (expressed as an index)
    * Yearly salary
    * Yearly bonus
    * Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)
    * Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)
    * Gym membership allowance ($0 to $500 annually)

    By calling _editCurJob_ method, the User object first invoke **EnterJob** Interface, which will be implemented by **Job** class. Once entering/editing has been completed, the user will have the options to: 
        1) Save the current job details, by calling _saveCurJob_ and save to _curJob_, then return to main menu
        2) Cancel without saving the current job details, then return to main menu


2. When _enterOffer_ is called, the user will be prompted to an interface to enter the offer details, similar to parameters in above regarding current job details. 

    By calling _enterOffer_ method, the User object will first invoke **EnterJob** Interface, which will be implemented by **Job** class. Once all details have been entered, the user will have the options to: 
        1) Save the job offer details, by calling _saveOffer_ and save to _offerList_, then return to main menu
        2) Cancel without saving the offer details, then return to main menu
        3) Compare the offer (if saved) with current job details (if present)

3. When _adjustSettings_ is called, the user will be prompted to an interface to assign integer weights of below items:
    * Yearly salary
    * Yearly bonus
    * Allowed weekly telework days
    * Leave time 
    * Gym membership allowance

    **If no weights are assigned, all factors are set to '1' by default**

4. When _compareOffer_ is called, the user will be prompted to an interface to choose 2 offers for comparison. Then a table comparing the two jobs, displaying, for each job:
    * Title
    * Company
    * Location
    * Cost of living in the location
    * Yearly salary
    * Yearly bonus
    * Allowed weekly telework days
    * Leave time
    * Gym membership allowance

    Then the user will have the options to:
        1) Perform another comparison
        2) Exit and go back to the main menu

    By calling _compareOffer_ method, the User object will first invoke **Compare** class and call _compare_ method first, which calls **EnterJob** Interface to calculate score for ranking each offer based on current settings. The use will then be shown a list of job offers, displayed as Title and Company, ranked from best to worst scores, and including the current job (if present). When ranking the job offers, a scroe is calculated as a weighted sum of:

    AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

    where:
    AYS = yearly salary adjusted for cost of living
    AYB = yearly bonus adjusted for cost of living
    GYM = Gym Membership Allowance ($0 to $500 annually)
    LT = leave time
    RWT = telework days per week
    The rationale for the RWT subformula is:
    a. value of an employee hour = (AYS / 260) / 8
    b. commute hours per year (assuming a 1-hour/day commute) = 1 * (260 - 52 * RWT)
    c. therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8