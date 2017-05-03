<%-- 
Document   : list-tujuan
Created on : Apr 17, 2017, 3:43:09 PM
Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Tambah Kota Asal
</button>

<br/>

<!-- adding Modal -->
<form:form commandName="kotaAsal" cssClass="form-horizontal blogForm">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Masukan kota Asal baru</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="asal" class="col-sm-2 control-label">Nama Kota:</label>
                        <div class="col-sm-10">
                            <form:input path="asal" cssClass="form-control" autofocus="autofocus"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save"/> 
                </div>
            </div>
        </div>
    </div>
</form:form>
<br /><br />

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
            <th>Kota Asal</th>
            <th>Operation</th>
        </tr>
    </thead>
    <body>
          <c:forEach items="${asalkota}" var="asalkota">
        <tr>
            <td>
            
                 <c:out value="${asalkota.id}"/>
              
            </td>
            <td>
            
                 <c:out value="${asalkota.asal}"/>
              
            </td>
            <td>
                <a href="<spring:url value="/jadwal/asal/remove/${asalkota.id}.html"/>" class="btn btn-danger triggerRemove">
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
</di