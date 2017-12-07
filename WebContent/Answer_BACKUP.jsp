<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="ISO-8859-1">
<title>Answer - Jeopardy!</title>
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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/mediaelement/4.2.7/mediaelement-and-player.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/mediaelement/4.2.7/mediaelementplayer.min.css" />

<link href="https://fonts.googleapis.com/css?family=Martel:700,900"
	rel="stylesheet">
<link rel="stylesheet" href="styles.css">

<script>
	$(document).ready(function() {
		$('video, audio').mediaelementplayer({
			// Do not forget to put a final slash (/)
			pluginPath : 'https://cdnjs.com/libraries/mediaelement/',
			// this will allow the CDN to use Flash without restrictions
			// (by default, this is set as `sameDomain`)
			shimScriptAccess : 'always'
		// more configuration
		});
	});
</script>
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
							<div class="col-sm question">
								<div style="" class="row">
									<div class="col col-md-9 text-left"><%=session.getAttribute("category")%>,
										worth $<%=session.getAttribute("worth")%></div>
									<div class="col col-md-1 text-right">
										<button class="question questionButton" type="submit"
											value="skip" name="skip">SKIP</button>
									</div>
									<div class="col col-md-2 text-right">
											<%
												if (request.getAttribute("isAnswered") != null) {
													out.println("<button class='question questionButton' onclick=\"location.href = 'Jeopardy.jsp';\">CONTINUE</button>");
												}
											%>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm expandedQuestion" align="center">
								<%
									String q = session.getAttribute("question").toString();

									if (q.matches(".*.mp3")) {
										out.println("<audio width='75%' type='audio/mp3' class='mejs_player' src='media/snipAtTheTune/" + q
												+ "'/></audio>");
									} else if (q.matches(".*.jpg|.*.png")) {
										out.println("<img src='media/orangeInNature/" + q + "' width='100%'>");
									} else {
										out.println(q);
									}
								%>
							</div>
						</div>
						<div class="row">
							<div class="col-sm question <jsp:">
								<button class="question questionButton" type="submit" value="a"
									name="chosenAnswer" 
									<% if(request.getAttribute("isAnswered") != null) { out.println("disabled"); } %> > 
									<%=session.getAttribute("a")%></button>
							</div>
							<div class="col-sm question
								<% if(request.getAttribute("isAnswered") != null) {
									if(request.getAttribute("chosenAnswer").toString().equals("b")) {
										if(request.getAttribute("correctAnswer").toString().equals("b")) {
											out.println(" rightChoice");
										} else {
											out.println(" wrongChoice");
										}
									}
								} %>">
								<button class="question questionButton" type="submit" value="b"
									name="chosenAnswer"
									<% if(request.getAttribute("isAnswered") != null) { out.println("disabled"); } %> >
									<%=session.getAttribute("b")%></button>
							</div>
						</div>
						<div class="row">
							<div class="col-sm question 
								<% if(request.getAttribute("isAnswered") != null) {
									if(request.getAttribute("chosenAnswer").toString().equals("c")) {
										if(request.getAttribute("correctAnswer").toString().equals("c")) {
											out.println(" rightChoice");
										} else {
											out.println(" wrongChoice");
										}
									}
								} %>">
								<button class="question questionButton" type="submit" value="c"
									name="chosenAnswer"
									<% if(request.getAttribute("isAnswered") != null) { out.println("disabled"); } %> >
									<%=session.getAttribute("c")%></button>
							</div>
							<div class="col-sm question">
								<button class="question questionButton" type="submit" value="d"
									name="chosenAnswer"
									<% if(request.getAttribute("isAnswered") != null) { out.println("disabled"); } %> >
									<%=session.getAttribute("d")%></button>
							</div>
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
			<div class="row">
				<div class="col">
					<br>

				</div>
			</div>
			<div class="row"></div>
		</div>
	</div>
</body>
</html>