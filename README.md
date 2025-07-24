<h1 align="center">🎓 BrightMind Institute Portal</h1>

<p align="center">
  A full-stack Spring MVC based web application for managing student registrations, course enrollments, and admin operations for a coaching institution.
</p>

<hr>

## 📌 Features

- 🏫 Dynamic Homepage with sections: Home, About, Courses, Announcements, Contact Us, and Login
- 📩 Course Inquiry Form with email-based confirmation using JavaMail
- 💳 Razorpay Payment Integration for secure course fee transactions
- 🧑‍🎓 Student Registration, Login & Dashboard to view enrolled courses
- 🛠️ Admin Panel with CRUD operations for Courses & Announcements
- 🔄 Real-time update reflection on homepage
- 🔐 Role-based access control (Student/Admin)
- 📧 Automated email notifications for registration success and login credentials

---

## 🛠️ Tech Stack

| Layer           | Technology Used                            |
|----------------|---------------------------------------------|
| **Frontend**    | HTML, JSP, Bootstrap, CSS                   |
| **Backend**     | Java, Spring MVC, Spring Data JPA           |
| **Database**    | MySQL                                       |
| **Tools**       | Eclipse/IntelliJ, Apache Tomcat, Git        |
| **Others**      | JavaMail API, Razorpay API (Payment)        |

---

## 🧑‍💻 Project Overview

The application simulates a real coaching institute workflow:

- Users can explore courses, make inquiries, and view batch announcements.
- Upon course enrollment, Razorpay is triggered for payment.
- Successful transactions trigger automated email delivery of login credentials.
- Admins can manage course and announcement details, view enrollments, and send payment reminders.
- All student details are stored securely, and sessions are managed properly.
