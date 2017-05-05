<%-- 
Document   : list-tujuan
Created on : Apr 17, 2017, 3:43:09 PM
Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Tambah Jadwal
</button>

<br/>

<!-- adding Modal -->
<form:form commandName="Jadwals" cssClass="form-horizontal blogForm">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Masukan jadwal baru</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Nama Kota Asal</label>
                        <div class="col-sm-10">
                            <form:select cssClass="form-control" path="kotaAsal">
                                <form:option value="">---SELECT---</form:option>
                                <c:forEach items="${asalkota}" var="asalkota">
                                      <form:option value="${asalkota.asal}">${asalkota.asal}</form:option>
                                </c:forEach>
                            </form:select>
                            <form:errors path="kotaAsal" />

                        </div>
                    </div>
               
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Nama Kota Tujuan</label>
                        <div class="col-sm-10">
                           <form:select cssClass="form-control" path="kotaTujuan">
                                <form:option value="">---SELECT---</form:option>
                                <c:forEach items="${tujuankota}" var="tujuankota">
                                      <form:option value="${tujuankota.tujuan}">${tujuankota.tujuan}</form:option>
                                </c:forEach>                      
                            </form:select>
                            <form:errors path="kotaTujuan" />
                        </div>
                    </div>
                
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Tanggal Berangkat</label>
                        <div class="col-sm-10">
                            <form:input path="tanggalBerangkat" cssClass="form-control" id="datepicker" />
                             <form:errors path="tanggalBerangkat" />
                        </div>
                    </div>
                
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Jam Berangkat</label>
                        <div class="col-sm-10">
                            <form:input path="jamBerangkat" cssClass="form-control" id="basicExample"/>
                             <form:errors path="jamBerangkat" />
                        </div>
                    </div>
                
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Harga Tiket</label>
                        <div class="col-sm-10">
                            <form:input path="harga" cssClass="form-control" />
                             <form:errors path="harga" />
                        </div>
                    </div>
              
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Max Seat</label>
                        <div class="col-sm-10">
                            <form:input path="seat" cssClass="form-control" />
                            <form:errors path="seat" />
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
<script src="web-start/scripts/jquery.plugin.js"></script>
<script src="web-start/scripts/jquery.datepick.js"></script>
<link rel="stylesheet" href="web-start/styles/jquery.datepick.css"> 
  
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
        $("#datepicker").datepick({dateFormat: 'dd/mm/yyyy',popupContainer: '#myModal',defaultDate: new Date(), selectDefaultDate: true});
        $('.nav-tabs a:first').tab('show');
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
         $(".blogForm").validate({
                    rules: {
                        kotaAsal: {
                            required: true
                        },
                        kotaTujuan: {
                            required: true
                           
                        },
                        tanggalBerangkat: {
                            required: true,
                            date:true
                           
                        },
                        jamBerangkat: {
                            required: true
                        },
                        harga: {
                            required: true,
                            number:true,
                            min:[1]
                        },
                        seat: {
                            required: true,
                            number:true,
                            min:[1]
                        }
                        
                    },
                    highlight : function (element){
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight : function (element){
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                });
    });
    
</script>


<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Kota Asal</th>
            <th>Kota Tujuan</th>
            <th>Tanggal Berangkat</th>
            <th>Jam Berangkat</th>
            <th>Harga</th>
            <th>Seat</th>
            <th>Operation</th>
        </tr>
    </thead>
    <body>
        <c:forEach items="${schedules}" var="schedules">
        <tr>
            <td>

                <c:out value="${schedules.id}"/>

            </td>
            <td>
                <c:out value="${schedules.kotaAsal}"/>
            </td>
            <td>
                <c:out value="${schedules.kotaTujuan}"/>
            </td>
            <td>
                <fmt:formatDate value="${schedules.tanggalBerangkat}" pattern="dd-MM-yyyy" />              
            </td>
            <td>
                <c:out value="${schedules.jamBerangkat}"/>
            </td>
            <td>
                <c:out value="${schedules.harga}"/>
            </td>
            <td>
                <c:out value="${schedules.seat}"/>
            </td>
            <td>
                <a href="<spring:url value="/jadwal/remove/${schedules.id}.html"/>" class="btn btn-danger triggerRemove">
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