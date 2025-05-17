# Ducklings

[UML Diagram](EntityCD.puml)

## Tech Stack
- Spring Boot
- Spring Data / Hibernate
- Spring Security with JWT
- BCrypt for password encryption

## User Stories
- As an administrator, I want to be able to create and enroll a child into a classroom
- As an administrator, I want to be able to grant families access to their child's day
- As an administrator, I want to be able to view all classrooms and their enrolled students
- As an administrator, I want to be able to create and edit classrooms


- As a classroom, I want to be able to see all children enrolled in my room
- As a classroom, I want to be able to get all of an enrolled child's logs
- As a classroom, I want to be able to add activities to an enrolled child's daily logs
- As a classroom, I want to be able to edit previously added activities
- As a classroom, I want to be able to delete previously added activities


- As a family member, I want to be able to see all of my child's daily logs
- As a family member, I want to receive a summary of my child's day
- As a family member, I want to see all my children

## Endpoints
### Children
- GET: getChildById (/api/children/{childId})
- POST: createChild (/api/children) (admin only)
- PUT: updateChildById (/api/children/{childId}) (admin only)

### Classrooms
- GET: getAllClassrooms (/api/classroom) (admin only)
- GET: getChildrenByClassroomId (/api/classroom/{classroomId})
- POST: createClassroom (/api/classroom) (admin only)
- PUT: updateClassroomById (/api/classroom/{classroomId}) (admin only)

### Users
- GET: getChildrenByUserId (/api/users/{userId})
- POST: createUser (/api/users) (admin only)
- PUT: updateUser (/api/users/{userId}) (admin only)

### Daily Logs
- GET: getDailyLogsById (/api/children/{childId}/daily-logs)
- GET: getDailyLogById (/api/children/{childId}/daily-logs/{dailyLogId})
- POST: createDailyLog (/api/children/{childId}/daily-logs)

### Activity Logs
- POST: createActivityLog (/api/daily-logs/) 
- PUT: updateActivityLogById (/api/daily-logs/{dailyLogId}/activity/{logId})
- DELETE: deleteActivityLogById (/api/daily-logs/{dailyLogId}/activity/{logId})

## Entities

### User
- id : Long
- name : String
- username : String
- password : String
- authority : List\<Authority>

### Classroom
- id : Long
- name : String
- ageGroup : AgeGroupEnum
- children : List\<Child> @OneToMany
- classroomUser : User

### Authority
- id : Long
- authority : String
- user : User

### Child
- id : Long
- name : String
- dateOfBirth : LocalDate
- classroom : Classroom @ManyToOne
- familyUsers : List\<User> @ManyToMany
- dailyLog : List\<DailyLog> @OneToMany
- notes : String

### DailyLog
- id : Long
- date : LocalDate
- child : Child @ManyToOne
- activityLog : List\<ActivityLog> @OneToMany

### ActivityLog (abstract)
- id : Long
- dailyLog : DailyLog @ManyToOne
- startTime : LocalTime
- notes : String

#### FoodLog
- amount : FoodAmountEnum

#### SleepLog
- endTime : LocalTime

#### BathroomLog
- contents : List\<BathroomContentEnum>

#### DiaperLog
- contents : List\<DiaperContentEnum>
- appliedCream : Boolean

#### BottleLog
- totalOunces : Float
- ouncesDrank : Float
- contents : List\<BottleContentEnum>

## Tables

### users
    - id : number (pk)
    - name : varchar
    - username : varchar
    - password : varchar

### children
    - id : number (pk)
    - name : varchar
    - dateOfBirth : date
    - classroom_id : number (fk)
    - notes : varchar

### user_children (joint table)
    - user_id : number (fk)
    - child_id : number (fk)

### classrooms
    - id : number (pk)
    - name : varchar
    - ageGroup : varchar
    - user_id : number (fk) // classroom username

### authorities
    - id : number (pk)
    - authority : varchar
    - user_id : number (fk)

### daily_logs
    - id : number (pk)
    - date : date
    - child_id : number (fk)

### food_logs
    - id : number (pk)
    - daily_log_id : number (fk)
    - start_time : time
    - amount : varchar
    - notes : text

### sleep_logs
    - id : number (pk)
    - daily_log_id : number (fk)
    - start_time : time
    - end_time : time
    - notes : text

### bathroom_logs
    - id : number (pk)
    - daily_log_id : number (fk)
    - start_time : time
    - contents : varchar
    - notes : text

### diaper_logs
    - id : number (pk)
    - daily_log_id : number (fk)
    - start_time : time
    - contents : varchar
    - appliedCream : boolean
    - notes : text

### bottle_logs
    - id : number (pk)
    - daily_log_id : number (fk)
    - start_time : time
    - totalOunces : real?
    - ouncesDrank : real?
    - contents : varchar
    - notes : text

# TO DO:
    SET UP SPRING SECURITY, IMPLEMENT IT WITH BCRYPT