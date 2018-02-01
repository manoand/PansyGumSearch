<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="gtco-section">
	<div class="gtco-container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2  text-center">
				<h2>Liste des bonbons</h2>
			</div>
		</div>
		<form id="formListObject" action="" method="POST">
			<div class="row">
				<table class="tab">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Couleur</th>
							<th>Poids</th>
							<th>Composition</th>
							<th></th>
							<th></th>						
						<tr>
					</thead>
					<tbody>
						<c:forEach var="bonbon" items="${listBonbon}">
							<tr>
								<td>${bonbon.nom}</td>
								<td>${bonbon.couleur}</td>
								<td>${bonbon.poids}</td>
								<td>${bonbon.composition}</td>
								<td class="text-center">
									<a href="#" onclick="submitForm('formListObject','modifification','idBonbon','${bonbon.id}')">
										<img src="/images/crayon.png" />
									</a>
								</td>
								<td class="text-center">
									<a href="#" onclick="submitForm('formListObject','suppression','idBonbon','${bonbon.id}')">
										<img src="/images/croix.png" />
									</a>
								</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
				<input id="idBonbon" type="hidden" name="idBonbon">
			</div>	
		</form>	
	</div>
</div>	

<script>
	function submitForm(idForm,action,idBonbon,valId){
		$('#'+idForm).attr('action',action);
		$('#'+idBonbon).val(valId);
		$('#'+idForm).submit();
	}
</script>