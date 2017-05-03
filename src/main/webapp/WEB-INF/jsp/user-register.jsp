<%-- 
    Document   : users
    Created on : Mar 20, 2017, 1:15:08 PM
    Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>



<form:form commandName="user" cssClass="form-horizontal registrationForm">
    <c:if test="${param.succes eq true}">
        <div class="alert alert-success">Registration Successfull</div>
    </c:if>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control" autofocus="autofocus"  />
            <form:errors path="name" />
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email" />
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Alamat:</label>
        <div class="col-sm-10">

            <form:input path="alamat" cssClass="form-control" id=""/>
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Gender:</label>
        <div class="col-sm-10">
            <form:select cssClass="form-control" path="gender">
                <form:option value="">---SELECT---</form:option>
                <form:option value="male">MALE</form:option>
                <form:option value="female">FEMALE</form:option>

            </form:select>
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Telepon:</label>
        <div class="col-sm-10">
            <form:input path="telepon" cssClass="form-control"/>
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
            <form:password path="password" cssClass="form-control"/>
            <form:errors path="password" />
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password again:</label>
        <div class="col-sm-10">
            <input type="password" name="password_again" id="password_again" class="form-control"/>                 
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
        </div>
    </div>
</form:form>


<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<script type="text/javascript">
    
    $(document).ready(function () {
        $("#datepicker").datepicker();
        $(".registrationForm").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3,
                            remote: {
                                url: "<spring:url value="/register/available.html"/>",
                                type: "get",
                                data: {
                                    username: function () {
                                        return $("#name").val();
                                    }
                                }
                            }
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        string: {
                            required: true
                        },
                        password: {
                            required: true,
                            minlength: 5
                        },
                        password_again: {
                            required: true,
                            minlength: 5,
                            equalTo: "#password"
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    },
                    messages: {
                        name: {
                            remote: "such username already exists dude"
                        }
                    }
                });
    });
</script>