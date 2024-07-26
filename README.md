Name:p pruthvi
Company: CODTECH IT SOLUTIONS
ID:CT12D1569
Domain:Android Development
Duration:july to september 2024
Mentor:

 Overview of the project

 project:simpe Todo Task Application in java

   Project Description: To-Do Task App

The To-Do Task app is an Android application designed to help users manage their daily tasks efficiently and effectively. This project aims to provide a comprehensive and user-friendly solution for task management, integrating key features such as task creation, task completion, deadline setting, persistent storage, and timely notifications.

 Key Features

1. **Task Creation and Management:**
   - Users can easily add new tasks by entering a task description, selecting a date, and specifying a time. 
   - Tasks are displayed in a visually appealing list format, with each task encapsulated in a `CardView` for a clean and modern look.

2. **Task Completion:**
   - Each task in the list includes a checkbox that users can check to mark the task as completed. 
   - This visual feedback helps users track their progress and stay organized.

3. **Persistent Storage:**
   - The app uses an SQLite database to store tasks persistently. 
   - This ensures that tasks are retained across app sessions, even if the app is closed or the device is restarted.

4. **Date and Time Picker:**
   - Users can set specific deadlines for tasks using integrated date and time pickers.
   - This feature allows users to schedule their tasks accurately and ensures timely reminders.

5. **Notifications:**
   - The app schedules notifications to remind users of their tasks at the specified times.
   - Notifications are managed using Android's `AlarmManager` and `PendingIntent`, ensuring that alerts are delivered promptly.

6. **Long-Press Deletion:**
   - Users can long-press on a task to delete it, providing an easy and intuitive way to manage the task list.

7. **User Interface:**
   - The app features a clean and intuitive interface with a `FloatingActionButton` for quick task additions.
   - Tasks are displayed in a `ListView` with items in `CardView` for a modern and visually appealing design.

 Technical Details

1. **MainActivity.java:**
   - Manages the main functionality of the app, including displaying tasks, adding new tasks, and scheduling notifications.
   - Contains methods to show date and time pickers, add tasks to the database, and update the task list.

2. **Task.java:**
   - A model class that encapsulates the properties of a task, including description, completion status, date, and time.
   - Provides getter and setter methods for these properties, facilitating data manipulation and transfer.

3. **DatabaseHelper.java:**
   - Manages the SQLite database operations, including creating the database, adding tasks, retrieving tasks, updating task status, and deleting tasks.
   - Ensures persistent storage of tasks and efficient database interactions.

4. **NotificationReceiver.java:**
   - A `BroadcastReceiver` that handles the display of notifications when a scheduled task is due.
   - Creates and shows notifications with task details to remind users of their pending tasks.

5. **Layouts and UI:**
   - XML layout files define the user interface components, including the main activity layout, task list items, and dialog for adding tasks.
   - Styles and themes are applied to ensure a consistent and aesthetically pleasing design.

 Summary

The To-Do Task app is a robust and feature-rich application designed to help users manage their tasks effectively. With its intuitive user interface, persistent storage, and advanced features like date and time pickers and notifications, the app provides a comprehensive solution for task management. By leveraging Android's built-in capabilities and providing a clean and modern design, the To-Do Task app ensures that users can stay organized and productive in their daily lives.


![imag1](https://github.com/user-attachments/assets/8b3f9a89-da7b-44d2-9cf6-f5783d00fe35)

![image2](https://github.com/user-attachments/assets/b628abbf-a7d6-429b-b069-33508c957c23)



