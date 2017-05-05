<%-- 
    Document   : user-detail
    Created on : Mar 20, 2017, 2:13:40 PM
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
<form:form commandName="pemesanan" cssClass="form-horizontal blogForm">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Masukan Pemesanan</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-10">
                            <form:input path="nama" cssClass="form-control" />
                             <form:errors path="nama" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Telepon:</label>
                        <div class="col-sm-10">
                            <form:input path="telepon" cssClass="form-control"  />
                             <form:errors path="telepon" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">ID Jadwal:</label>
                        <div class="col-sm-10">
                            <form:select cssClass="form-control" path="idJadwal">
                               <form:option value='0'>---SELECT---</form:option>
                                <c:forEach items="${schedules}" var="schedule">
                                    <form:option value="${schedule.id}">${schedule.id}</form:option>
                                </c:forEach>                      
                            </form:select>
                            <form:errors path="idJadwal" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Qty:</label>
                        <div class="col-sm-10">
                            <form:input path="qty" cssClass="form-control"  />
                             <form:errors path="qty" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Status Bayar:</label>
                        <div class="col-sm-10">
                           <form:radiobutton path="status" value="BELUM" checked="checked"/>BELUM LUNAS
                           <br>
                           <form:radiobutton path="status" value="LUNAS"/>LUNAS           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tujuan" class="col-sm-2 control-label">Tanggal Pesan</label>
                        <div class="col-sm-10" >
                            <form:input path="tanggalPesan" cssClass="form-control" id="datepicker"  />
                             <form:errors path="tanggalPesan" />
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

<!--Javascript-->
<script type="text/javascript">
    $(document).ready(function(){  
       $("#datepicker").datepick({dateFormat: 'dd/mm/yyyy',popupContainer: '#myModal',defaultDate: new Date(), selectDefaultDate: true});
       $('.triggerRemove').click(function (e){
          e.preventDefault();
          $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
          $("#modalRemove").modal();
       });
      
       $(".blogForm").validate({
                    rules: {
                        nama: {
                            required: true,
                            minlength: 1
                        },
                        telepon: {
                            required: true
                           
                        },
                        idJadwal: {
                            required: true
                           
                        },
                        qty: {
                            required: true,
                            range:[1,70]
                        },
                        tanggalPesan: {
                            required: true,
                            date:true
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
<!--buat tanggal-->
<script src="web-start/scripts/jquery.plugin.js"></script>
<script src="web-start/scripts/jquery.datepick.js"></script>
<link rel="stylesheet" href="web-start/styles/jquery.datepick.css"> 
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
                <a href="<spring:url value="/pemesanan/remove/${listPemesanan.id}.html"/>" class="btn btn-danger triggerRemove">
                    Remove
                </a>
            </td>
        </tr>
    </c:forEach>
</body>
</table>
<!-- Modal -->
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
</div>