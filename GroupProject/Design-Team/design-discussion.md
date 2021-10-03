
**Design 1 (Val)**  

Pros:
* Contains main entry point into program (part of requirements doc)

Cons:
* Too complex - Getters/setters add unnecessary complexity to diagram
* Not as extendable/flexible in the future given lack of abstract classes and/or interfaces
* Missing cardinality on relationships


**Design 2 (Robert)**

Pros:
* Contains main entry point into program (part of requirements doc)
* Abstract class of Job, which CurrentJobDetails and JobOffers inherits from, allows for easy modifiability in the future.
* Having CurrentJobDetails and JobOffers as separate classes allows them to be modified separately, tailored to fit their specific needs.

Cons:
* Duplication of some methods:  
  * CurrentJobDetails and JobOffers have some similar methods, which could probably be represented in the abstract class they both inherit from, to reduce duplicate copies of code with the same functionality. 
    * For example saveTheJobDetails() and saveTheJobOfferDetails() could probably be made into one method in the abstract class.  
    * Another example is the cancelAndExitWithoutSaving() and cancel() methods, the cancel feature can be provided by a common method in the abstract class, and the exit feature required in the former method could be its own method; this makes modification of the cancel feature in the future common to both easier from a single location, from the abstract class. 


**Design 3 (Zhaoran)**

Pros:
* Uses Interface to achieve total abstraction
* Only updates weightedSum (i.e. score) when comparison is called, therefore saves on unnecessary computing time
* Low coupling among classes

Cons:
* Does not contain entry point
* Relationship between Compare, EnterJob (interface) and Job seems unclear


**Design 4 (Arthur)**

Pros:
* Separate Location class allows for cost of living to be consistently maintained for job locations. I.e. The Cost of Living (COL) Index does not need to be updated for every job in a given location, but rather, the COL is updated for the location object.
* Supports Model-View-Controller (MVC) Design paradigm 
* Allows job scores to be updated dynamically through the use of a Map from Job to job score.

Cons:
* Does not contain entry point
* Separate Company class (unnecessary; could be useful if we had requirements to filter by company - but we don’t)
* Does not separately maintain offers as an object - makes it more tedious to ensure consistency


**Team Design**

We've selected Arthur's updated UML design.  

Some commonalities to the other proposed designs we identified are:  
* Ability to clearly identify components for Job, ComparisonWeights, and JobOffers.  
* Similar data structures to hold list of job/jobOffers (list). 
* Similar default values for ComparisonWeights. 

Some differences to the other proposed designs are:  
* New Location class to separate costOfLivingIndex from the Job class. 
* Use MVC framework to create clear separation between models and views; this helps minimize dependencies within the design. 
* Usage of a separate data structure for the job rankings functionality. 

To summarize we believe the following components were key factors in our ultimate design decisions:
* Minimize complexity (e.g. removing unnecessary classes and functions)
* Minimize dependencies (e.g. creating separation between models and views)
* Improve consistency of data (e.g. location is consistent for each job instance)
* We assumed the project is tightly scoped and thus would not require ongoing development and feature additions (i.e. we did not introduce additional complexity through abstract classes and interfaces)


Subsequent changes to original design:  
* Added entry point into the application (i.e. Main) which will instantiate a controller object.
* Removed Company class largely to simplify UML structure diagram (without losing functionality) and not add specifications that are not part of the requirements document. 
* Moved attribute "gymAllowance:int" from Company class to Job class as part of UML cleanup exercise.
* Introduced a new JobOffers class to hold a list of jobOffers (including the current job) and rankedJobOffers attributes. These attributes  were previously part of the controller. We did this to simplify the controller and reduce unncessary coupling towards the controller.
* Visually removed getters and setters as part of the requirements document to simplify our UML representation although they are implicitly there.


**Summary**  

Through our discussion we were able to quickly identify the pros and cons of each design, which gave each of us perspective on how others thought about the problem. This provided us with tangible opportunities for design improvement. Further, by seeing other designs, we obtained a better understanding of OOP and other methodologies used in industry standard and clever ways to represent the system and its functionalities. Through this exercise of discussing the problem in interative fashion, this provided us with practice to develop industry standard agile development practices.


