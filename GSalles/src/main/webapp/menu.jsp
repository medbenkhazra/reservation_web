<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="index.html">
              <i class="mdi mdi-grid-large menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
          <li class="nav-item nav-category">UI Elements</li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-floor-plan"></i>
              <span class="menu-title">UI Elements</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="pages/ui-features/buttons.html">Buttons</a></li>
                <li class="nav-item"> <a class="nav-link" href="pages/ui-features/dropdowns.html">Dropdowns</a></li>
                <li class="nav-item"> <a class="nav-link" href="pages/ui-features/typography.html">Typography</a></li>
                <li class="nav-item"> <a class="nav-link" href="gsalles.jsp">Gestion des salles</a></li>
                <li class="nav-item"> <a class="nav-link" href="gcreneau.jsp">Gestion des creneaux </a></li>
                <li class="nav-item"> <a class="nav-link" href="gclients.jsp">Gestion des clients</a></li>
              </ul>
            </div>
          </li>
         
          
          
          <li class="nav-item nav-category">PAGES</li>
          
          <li class="nav-item"> <a class="nav-link" href="gsalles.jsp">Gestion des salles</a></li>
          <li class="nav-item"> <a class="nav-link" href="gcreneau.jsp">Gestion des creneaux </a></li>
          <li class="nav-item"> <a class="nav-link" href="gclients.jsp">Gestion des clients</a></li>
        </ul>
      </nav>

</body>
</html>