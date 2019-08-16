<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>
			<c:set var="title" value="Liste des cites" scope="request"/>
			<c:out value=" ${ requestScope.title } "/>
		</title>
		<c:import url="includeAddingMenuStyle.jsp"/>
		<c:import url="includeAddingListStyle.jsp"/>
	</head>
	
	<body>
		<div class="container">
			<ul id="menu" class="menuMain">
				<li class="trigger">
					<a class="icon iconMenu"><span><c:out value="Menu"/></span></a>
					<nav class="menuWrapper">
						<div class="scroller">
							<ul class="menu">
								<li class="searchItem">
									<input placeholder="Recherche" type="search" class="search">
									<a class="icon iconSearch"><span><c:out value="Recherche"/></span></a>
								</li>
								<li>
									<a class="icon iconIncident"><c:out value="Cite"/></a>
									<ul class="submenu">
										<li><a href="<c:url value="#"/>" class="icon iconSubm"><c:out value="Enregistrer une cite"/></a></li>
										<li><a href="<c:url value="\Tripcity\list_cites"/>" class="icon iconSubm"><c:out value="Cites"/></a></li>
										<li><a href="<c:url value="#"/>" class="icon iconSubm"><c:out value="Mettre à jour"/></a></li>
									</ul>
								</li>
								<li>
									<a href="<c:url value=""/>" class="icon iconEdition"><c:out value="Autres"/></a>
								</li>
							</ul>
						</div>
					</nav>
				</li>
				<li><a class="codropsIcon " href="<c:url value=""/>"><span><c:if test="${!empty sessionScope.userSession }"><c:out value="Salut ${ sessionScope.userSession.getSuperviseurPrenom() }, vous êtes connecté via l'adresse ${ sessionScope.userSession.getSuperviseurEmail() }"/></c:if></span></a></li>
				<li><a class="codropsIcon " href="<c:url value=""/>"><span><c:out value="Acceuil"/></span></a></li>
			</ul>
			

			<div class="component">
				<section>
					<div class="tabs tabs-style-linetriangle">
						<nav>
							<ul></ul>
						</nav>
						<div class="content-wrap">
							<section id="section-linetriangle-1">
								<h2><c:out  value="Liste complète" /></h2><br/>
								<p><c:out value="Ci-dessous, nous avons la liste complète des cites enregistrés dans notre base de données" /></p><br/>
								<table>
									<thead>
										<tr>
											<th> <c:out value="Nom" /> </th>
											<th> <c:out value="Localisation" /> </th>
											<th> <c:out value="Contact Concierge" /> </th>
											<th> <c:out value="Departement" /> </th>
											<th> <c:out value="Latitude" /> </th>
											<th> <c:out value="Longitude" /> </th>
											<th> <c:out value="Altitude" /> </th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ requestScope.city }" var="mapCites" varStatus="boucle">
											<tr><td class="user-name"><a href="<c:url value="#"> <c:param  name="citeId" value="${ mapCites.key }"/></c:url>"> ${ mapCites.value.getCiteNom() }</a></td><td class="user-name">${ mapCites.value.getCiteLocalisation() }</td><td class="user-name">${ mapCites.value.getCiteContactConcierge() }</td><td class="user-name">${ mapCites.value.getCiteDepartement() }</td><td><c:out value="${ mapCites.value.getCiteLatitude() }"/></td><td><c:out value="${ mapCites.value.getCiteLongitude() }"/></td><td><c:out value="${ mapCites.value.getCiteAltitude() }"/></td></tr>
										</c:forEach>
									</tbody>
								</table>
								<p class="filler"></p>
								<p class="filler"></p>
								<p class="filler"></p>
							</section>
							<c:if test="${ empty listeCites }">
								<p class="erreur"><c:out value="Aucune cite enregistrées."/></p>
							</c:if>
						</div>
					</div>
				</section>
			</div>
		</div>
		<script src="./JS/plitable/classie.js"></script>	
		<script src="./JS/plitable/menu.js"></script>
		<script src="./JS/jquery.js"></script>
		<script>
			new Menu(document.getElementById('menu'));
		</script>
	</body>
</html>