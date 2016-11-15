<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accueil</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style.css"/>" />
</head>
<body>
	<div>
		<p class="info">${ message }</p>
	</div>
<div>
		<div class="tab-content">
		
		<div id="deco">
		<form method="get" action="<c:url value="/deco"/>">
			<input type="submit" id="submit" name="deco" value="Déconnexion">
		</form>
		</div>
		
			<div id="show">
				<h1>Liste des Messages : </h1>
			</div>

			<div id="publish">
				<h1>Entrez votre message : </h1>

				<form id="publishMessage" method="post" action="<c:url value="/index"/>">

					<div class="top-row">
						<div class="field-wrap">
							<label> Message <span class="req">*</span>
							</label> <input name="message" type="text" required
								autocomplete="off">
						</div>

					<button name="publishMessage" type="submit"
						class="button button-block" >
					Go
					</button>

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="<c:url value="/include/index.js"/>"></script>

</body>

</html>
