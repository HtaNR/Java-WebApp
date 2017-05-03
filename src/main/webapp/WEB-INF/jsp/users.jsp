<%-- 
    Document   : users
    Created on : Mar 20, 2017, 1:15:08 PM
    Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>
<!DOCTYPE html>

<script type="text/javascript">
    $(document).ready(function(){
       $('.nav-tabs a:first').tab('show');
       $('.triggerRemove').click(function (e){
          e.preventDefault();
          $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
          $("#modalRemove").modal();
       });
    });
</script>


<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Alamat</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Operations</th>
        </tr>
    </thead>
    <body>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>
                    <c:out value="${user.id}"/>
            </td>
            <td>
                <a href="<spring:url value="/users/${user.id}.html"/>">
                    <c:out value="${user.name}"/>
                </a>
            </td>
            <td>
                    <c:out value="${user.email}"/>
            </td>
            <td>
                    <c:out value="${user.alamat}"/>
            </td>
            <td>
                    <c:out value="${user.gender}"/>
            </td>
            <td>
                    <c:out value="${user.telepon}"/>
            </td>
         
            <td>
                <a href="<spring:url value="/users/remove/${user.id}.html"/>" class="btn btn-danger triggerRemove">
                Remove
                </a>
            </td>
        </tr>
        </c:forEach>
    </body>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove User</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>