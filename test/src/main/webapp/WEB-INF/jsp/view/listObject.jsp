<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="gtco-section">
	<div class="gtco-container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2  text-center">
				<h2>Liste des bonbons</h2>
			</div>
		</div>
		<div class="row">
			<table class="tab">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Couleur</th>
						<th>Poids</th>
						<th>Composition</th>
					<tr>
				</thead>
				<tbody>
					<c:forEach var="bonbon" items="${listBonbon}">
						<tr>
							<td>${bonbon.nom}</td>
							<td>${bonbon.couleur}</td>
							<td>${bonbon.poids}</td>
							<td>
								${bonbon.composition}
								<input type="hidden" value ="${bonbon.id}">
							</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>	
	</div>
</div>	