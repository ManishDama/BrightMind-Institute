<nav class="navbar navbar-expand-sm navbar-dark bg-primary shadow-sm fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="/studenthome">Edu Tech</a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mymenu" aria-controls="mymenu" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="mymenu">
      <ul class="navbar-nav me-auto mb-2 mb-sm-0">
      	<li class="nav-item">
          <a class="nav-link text-white fw-semibold" href="/mycourses">My Courses</a>
        </li>
      </ul>

      <ul class="navbar-nav ms-auto">
        <li class="nav-item d-flex align-items-center me-3">
          <span class="navbar-text text-white fw-medium"> welcome ${students.studentName}</span>
        </li>
        <li class="nav-item">
          <a class="btn btn-light  fw-semibold" href="/logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>