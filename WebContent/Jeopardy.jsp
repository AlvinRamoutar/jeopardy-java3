<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jeopardy!</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<script src="app.js"></script>

<link href="https://fonts.googleapis.com/css?family=Martel:700,900"
	rel="stylesheet">
<link rel="stylesheet" href="styles.css">
</head>

<body>

	<div class="container-fluid gameFrame">
		<div class="row">
			<div class="col text-left playerData"><%=session.getAttribute("username")%></div>
			<div class="col text-center">
				<img style="width: 60%;" src="media/images/Jeopardy-logo.png">
			</div>
			<div class="col text-right playerData"><%=session.getAttribute("score")%></div>
		</div>
		<div class="row"></div>
		<div class="row">
			<div class="col text-center">
				<div style="background-color: rgba(0, 0, 152, 0.80);"
					class="container">
					<form action="AnswerServlet">
						<div class="row">
							<div class="col-sm category">Language of Flowers</div>
							<div class="col-sm category">Steam Library</div>
							<div class="col-sm category">Snippets</div>
							<div class="col-sm category">Orange in Nature</div>
							<div class="col-sm category">Fruit of the Line</div>
							<div class="col-sm category">Calling</div>
						</div>
						<div class="row" id="lv1">
							<!-- 							<div id="c1_lv1" class="col-sm question"> -->
							<!-- 								<input class="question questionButton" type=submit value="$200" -->
							<!-- 									name="testQ"> -->
							<!-- 							</div> -->
							<!-- 							<div id="c2_lv1" class="col-sm question">$200</div> -->
							<!-- 							<div id="c3_lv1" class="col-sm question">$200</div> -->
							<!-- 							<div id="c4_lv1" class="col-sm question">$200</div> -->
							<!-- 							<div id="c5_lv1" class="col-sm question">$200</div> -->
							<!-- 							<div id="c6_lv1" class="col-sm question">$200</div> -->
						</div>
						<div class="row" id="lv2">
							<!-- 							<div id="c1_lv2" class="col-sm question">$400</div> -->
							<!-- 							<div id="c2_lv2" class="col-sm question">$400</div> -->
							<!-- 							<div id="c3_lv2" class="col-sm question">$400</div> -->
							<!-- 							<div id="c4_lv2" class="col-sm question">$400</div> -->
							<!-- 							<div id="c5_lv2" class="col-sm question">$400</div> -->
							<!-- 							<div id="c6_lv2" class="col-sm question">$400</div> -->
						</div>
						<div class="row" id="lv3">
							<!-- 							<div id="c1_lv3" class="col-sm question">$600</div> -->
							<!-- 							<div id="c2_lv3" class="col-sm question">$600</div> -->
							<!-- 							<div id="c3_lv3" class="col-sm question">$600</div> -->
							<!-- 							<div id="c4_lv3" class="col-sm question">$600</div> -->
							<!-- 							<div id="c5_lv3" class="col-sm question">$600</div> -->
							<!-- 							<div id="c6_lv3" class="col-sm question">$600</div> -->
						</div>
						<div class="row" id="lv4">
							<!-- 							<div id="c1_lv4" class="col-sm question">$800</div> -->
							<!-- 							<div id="c2_lv4" class="col-sm question">$800</div> -->
							<!-- 							<div id="c3_lv4" class="col-sm question">$800</div> -->
							<!-- 							<div id="c4_lv4" class="col-sm question">$800</div> -->
							<!-- 							<div id="c5_lv4" class="col-sm question">$800</div> -->
							<!-- 							<div id="c6_lv4" class="col-sm question">$800</div> -->
						</div>
						<div class="row" id="lv5">
							<!-- 							<div id="c1_lv5" class="col-sm question">$1000</div> -->
							<!-- 							<div id="c2_lv5" class="col-sm question">$1000</div> -->
							<!-- 							<div id="c3_lv5" class="col-sm question">$1000</div> -->
							<!-- 							<div id="c4_lv5" class="col-sm question">$1000</div> -->
							<!-- 							<div id="c5_lv5" class="col-sm question">$1000</div> -->
							<!-- 							<div id="c6_lv5" class="col-sm question">$1000</div> -->
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<br>
				<div id="accordion" role="tablist">
					<div class="card" style="background-color: rgba(0, 0, 84, 0.3);">
						<div class="card-header" role="tab" id="headingOne">
							<h5 class="mb-0 text-center"
								style="font-family: 'Martel', serif; font-weight: 900;">
								<a data-toggle="collapse" href="#collapseOne"
									aria-expanded="false" aria-controls="collapseOne"> NEED
									HELP? </a>
							</h5>
						</div>

						<div id="collapseOne" class="collapse show" role="tabpanel"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">
								<p style="color: white;">Anim pariatur cliche reprehenderit,
									enim eiusmod high life accusamus terry richardson ad squid. 3
									wolf moon officia aute, non cupidatat skateboard dolor brunch.
									Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
									tempor, sunt aliqua put a bird on it squid single-origin coffee
									nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
									craft beer labore wes anderson cred nesciunt sapiente ea
									proident. Ad vegan excepteur butcher vice lomo. Leggings
									occaecat craft beer farm-to-table, raw denim aesthetic synth
									nesciunt you probably haven't heard of them accusamus labore
									sustainable VHS.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row"></div>

	</div>

</body>
</html>