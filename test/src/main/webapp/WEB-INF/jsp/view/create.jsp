<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

		<div class="gtco-section">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2  text-center">
						<h2>${titre}</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						 <form:form method="POST" action="save" modelAttribute="bonbon">
							<div class="form-group">
								<label for="name">Nom</label>
								<form:input type="text" class="form-control"  path="nom"/>
							</div>
							<div class="form-group">
								<label for="name">Couleur</label>
								<form:input type="text" class="form-control"  path="couleur"/>
							</div>
							<div class="form-group">
								<label for="name">Poids</label>
								<form:input type="text" class="form-control" path="poids"/>
							</div>
							<div class="form-group">
								<label for="name">Composition</label>
								<form:input type="text" class="form-control" path="composition"/>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn btn-special" value="${action}">
							</div>
						</form:form>
					</div>
					<div class="col-md-5 col-md-push-1">
						<div class="owl-carousel owl-carousel-carousel">
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_1.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Paper Cup</h2></a>
									<p class="role">Web Design &amp; Mobile</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_2.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Notepad Mockup</h2></a>
									<p class="role">Web Design</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_3.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Fancy 3D text</h2></a>
									<p class="role">UI/UX</p>
								</div>
							</div>

							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_1.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Paper Cup</h2></a>
									<p class="role">Mobile App</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_2.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Notepad Mockup</h2></a>
									<p class="role">Branding</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_3.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Fancy 3D text</h2></a>
									<p class="role">UI/UX</p>
								</div>
							</div>

							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_1.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Paper Cup</h2></a>
									<p class="role">Web Design</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_2.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Notepad Mockup</h2></a>
									<p class="role">Branding &amp; UI</p>
								</div>
							</div>
							<div class="item">
								<div class="gtco-item">
									<a href="#"><img src="images/img_3.jpg" alt="" class="img-responsive"></a>
									<h2><a href="#">Fancy 3D text</h2></a>
									<p class="role">Illustrator</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	


