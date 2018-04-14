<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<style>
		body {
			padding-top: 5rem;
		}
		.starter-template {
			padding: 3rem 1.5rem;
			text-align: center;
		}
	</style>
	<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
</head>
<body>
<jsp:include page="../include/navbar.jsp" />
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<%--<c:url value="/j_spring_security_logout" var="logoutUrl" />--%>
	<%--<form action="${logoutUrl}" method="post" id="logoutForm">--%>
		<%--<input type="hidden" name="${_csrf.parameterName}"--%>
			<%--value="${_csrf.token}" />--%>
	<%--</form>--%>
	<%--<script>--%>
		<%--function formSubmit() {--%>
			<%--document.getElementById("logoutForm").submit();--%>
		<%--}--%>
	<%--</script>--%>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name}
		</h2>
		<div class="container">
			<div class="row">
				<div id="teachers" class="col-xs-6">
					<div><h2>Teachers: </h2></div>
					<div class="accordion" id="accordion">
						<div class="card" v-for="(teacher, index) in teachers" :key="'teacher' + teacher.id">
							<div class="card-header" :id="'teacher' + teacher.id">
								<h5 class="mb-0">
									<button class="btn btn-link" type="button" data-toggle="collapse" :data-target="'#collapseteacher' + teacher.id" aria-expanded="true" :aria-controls="'collapseteacher'">
										{{ teacher.fullName.firstname }} {{ teacher.fullName.lastname }} {{ teacher.fullName.midname }}
									</button>
								</h5>
							</div>

							<div :id="'collapseteacher' + teacher.id" class="collapsed" :aria-labelledby="'teacher' + teacher.id" data-parent="#accordion">
								<div class="card-body">
									<div class="mb-1">
										Birthday: {{ teacher.birthDate }}
									</div>
									<div class="mb-1">Lectures: </div>
									<div class="list-group">
										<a v-for="lecture in teacher.lectures" :key="'lecture' + lecture.id" href="#" class="list-group-item list-group-item-action">
											Name: {{ lecture.name }}  Credits: {{ lecture.credits }}
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="students" class="col-xs-6">
					<div><h2>Students:</h2></div>
					<div class="accordion" id="accordion2">
						<div class="card" v-for="(student, index) in students" :key="'student' + student.id">
							<div class="card-header" :id="'student' + student.id">
								<h5 class="mb-0">
									<button class="btn btn-link" type="button" data-toggle="collapse" :data-target="'#collapsestudent' + student.id" aria-expanded="true" :aria-controls="'collapsestudent'">
										{{ student.fullName.firstname }} {{ student.fullName.lastname }} {{ student.fullName.midname }}
									</button>
								</h5>
							</div>

							<div :id="'collapsestudent' + student.id" class="collapsed" :aria-labelledby="'student' + student.id" data-parent="#accordion2">
								<div class="card-body">
									<div class="mb-1">
										Course: {{ student.course }}
										Birthday: {{ student.studentData.birthDate }}
										Address: {{ student.studentData.address }}
									</div>
									<div class="mb-1">Lectures: </div>
									<div class="list-group">
										<a v-for="lecture in student.lectures" :key="'lecture' + lecture.id" href="#" class="list-group-item list-group-item-action">
											Name: {{ lecture.name }}  Credits: {{ lecture.credits }}
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="lectures" class="col-xs-6">
					<div><h2>Lectures:</h2></div>
					<div class="accordion" id="accordion3">
						<div class="card" v-for="(lecture, index) in lectures" :key="'lecture' + lecture.id">
							<div class="card-header" :id="'lecture' + lecture.id">
								<h5 class="mb-0">
									<button class="btn btn-link" type="button" data-toggle="collapse" :data-target="'#collapselecture' + lecture.id" aria-expanded="true" :aria-controls="'collapselecture'">
										{{ lecture.name }}
									</button>
								</h5>
							</div>

							<div :id="'collapselecture' + lecture.id" class="collapsed" :aria-labelledby="'lecture' + lecture.id" data-parent="#accordion3">
								<div class="card-body">
									<div class="mb-1">
										Credits: {{ lecture.credits }}
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="tests" class="col-xs-6">
					<div><h2>Tests:</h2></div>
					<div class="accordion" id="accordion4">
						<div class="card" v-for="(test, index) in tests" :key="'test' + test.id">
							<div class="card-header" :id="'test' + test.id">
								<h5 class="mb-0">
									<button class="btn btn-link" type="button" data-toggle="collapse" :data-target="'#collapsetest' + test.id" aria-expanded="true" :aria-controls="'collapsetest'">
										{{ test.testName }}
									</button>
								</h5>
							</div>

							<div :id="'collapsetest' + test.id" class="collapsed" :aria-labelledby="'test' + test.id" data-parent="#accordion4">
								<div class="card-body">
									<div class="mb-1">
										Test Type: {{ test.testType }}
										Text: {{ test.text }}
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script>
		new Vue({
			el: '#teachers',
			data: {
			    teachers: []
			},
			methods: {
                getAllTeachers: function() {
                    var that = this;
                    axios.get('/teachers', {
							headers: {
								'Content-Type': 'application/json'
							}
						})
                        .then(function(response) {
                            that.teachers = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
				}
			},
			created: function() {
			    this.getAllTeachers();
			}
		});
		new Vue({
            "el": '#students',
			data: {
                students: []
			},
			methods: {
                getAllStudents: function() {
                    var that = this;
                    axios.get('/students', {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                        .then(function(response) {
                            that.students = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
				}
			},
			created: function() {
                this.getAllStudents();
			}
		});
        new Vue({
            "el": '#lectures',
            data: {
                lectures: []
            },
            methods: {
                getAllLectures: function() {
                    var that = this;
                    axios.get('/lectures', {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                        .then(function(response) {
                            that.lectures = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }
            },
            created: function() {
                this.getAllLectures();
            }
        });
        new Vue({
            "el": '#tests',
            data: {
                tests: []
            },
            methods: {
                getAllTests: function() {
                    var that = this;
                    axios.get('/tests', {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                        .then(function(response) {
                            that.tests = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }
            },
            created: function() {
                this.getAllTests();
            }
        });
	</script>
</body>
</html>