<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>
			<c:set var="title" value="Bienvenue sur TripCity::Sup" scope="request"/>
			<c:out value=" ${ requestScope.title } "/>
		</title>
		<c:import url="includeAddingStyle.jsp"/>
	</head>
	
	<body>
		<div> 
			<span class="reference">
				<!-- MENU -->
			</span>
		</div>
		<div id="content">
			<div id="wrapper">
				<div id="steps">
					<form id="formElem" name="formElem" action="<c:url value="/connection"/>" method="post">
						<fieldset class="step">
							<legend> <c:out value="Connexion"/> </legend>
							<c:if test="${ !empty connexionForm.errors }">
								<p class="erreur" ><c:out value="${connexionForm.result }"/></p>
							</c:if>
							<p>
								<label for="utilisateur_email"> <c:out value="Adresse électronique"/> </label>
								<input id="superviseur_email" name="superviseur_email" value = "<c:out value="${user.getSuperviseurEmail() }"/>" />
							</p>
							<c:if test="${ !empty connexionForm.errors['superviseur_email'] }">
								<p class="erreur" ><c:out value="${connexionForm.errors['superviseur_email'] }"/></p>
							</c:if>
							<p>
								<label for="utilisateur_password"> <c:out value="Mot de passe"/> </label>
								<input id="superviseur_password" name="superviseur_password" type="password"/>
							</p>
							<c:if test="${ !empty connexionForm.errors['superviseur_password'] }">
								<p class="erreur" ><c:out value="${connexionForm.errors['superviseur_password'] }"/></p>
							</c:if>
							<p class="submit">
								<button id="bt_connect" type="submit"><c:out value="Se connecter"/> </button><br/>
							</p>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<script src="./JS/jquery.js"></script>
	</body>
</html>