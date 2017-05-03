<%-- 
Document   : list-tujuan
Created on : Apr 17, 2017, 3:43:09 PM
Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Tambah Pemesanan
</button>

<br/>

<!-- adding Modal -->
<form:form commandName="Pemesanan" cssClass="form-horizontal blogForm">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Masukan Pemesanan</h4>
                </div>
               
               
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Nama</label>
                        <div class="col-sm-10">
                            <form:input path="nama" cssClass="form-control"  />
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Telepon</label>
                        <div class="col-sm-10">
                            <form:input path="telepon" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Nama Jadwal</label>
                        <div class="col-sm-10">
                           <form:select cssClass="form-control" path="idJadwal">
                               <form:option value='0'>---SELECT---</form:option>
                                <c:forEach items="${schedules}" var="schedule">
                                    <form:option value="${schedule.id}">${schedule.id}</form:option>
                                </c:forEach>                      
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Qty</label>
                        <div class="col-sm-10">
                            <form:input path="qty" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Status Bayar</label>
                        <div class="col-sm-10">
                            <form:input path="status" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Tanggal Pesan</label>
                        <div class="col-sm-10">
                            <form:input path="tanggalPesan" cssClass="form-control" id="datepicker" />
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


<!--buat tanggal-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  </script>
  <script>
      $( function() {
    $('#basicExample').timepicker({ 'timeFormat': 'H:i' });
});
   
  </script>
<!--buat jam-->
<script src="web-start/scripts/jquery.timepicker.min.js"></script>

<link rel="stylesheet" href="web-start/styles/jquery.timepicker.css"> 



<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show');
        $('.triggerRemove').click(function (e) {
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
            <th>Nama</th>
            <th>Telepon</th>
            <th>ID Jadwal</th>
            <th>Qty</th>
            <th>Status Bayar</th>
            <th>Tanggal Pesan</th>
            <th>ID Member</th>
            <th>Total</th>
            <th>Operation</th>
        </tr>
    </thead>
    <body>
        <c:forEach items="${listPemesanan}" var="listPemesanan">
        <tr>
             <td>

                <c:out value="${listPemesanan.id}"/>

            </td>
            <td>

                <c:out value="${listPemesanan.nama}"/>

            </td>
            <td>
                <c:out value="${listPemesanan.telepon}"/>
            </td>
             <td>
                <c:out value="${listPemesanan.idJadwal}"/>
            </td>
           
            <td>
                <c:out value="${listPemesanan.qty}"/>
            </td>
            <td>
                <c:out value="${listPemesanan.status}"/>
            </td>
             <td>
                <fmt:formatDate value="${listPemesanan.tanggalPesan}" pattern="dd-MM-yyyy" />             
            </td>
             <td>
                <c:out value="${listPemesanan.idUser}"/>
            </td>
             <td>
                <c:out value="${listPemesanan.totalHarga}"/>
            </td>
            <td>
                <a href="<spring:url value="/jadwal/remove/${listPemesanan.id}.html"/>" class="btn btn-danger triggerRemove">
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
                <h4 class="modal-title" id="myModalLabel">Remove Jadwal</h4>
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