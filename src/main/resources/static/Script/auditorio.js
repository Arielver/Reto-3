$("document").ready(function () {
    getAudiencie();
});

const API = 'https://g624376352b5710-ogld6oe3ycol328l.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/audience/audience';

function btnSaveUpdate() {
    let botonSaUp = document.getElementById('btnSave');

    if (botonSaUp.textContent == 'Guardar auditorio') { postAudiencie(); }

    if (botonSaUp.textContent == 'Actualizar audiorio') {
        
        putAudiencie();
        botonSaUp.textContent = 'Guardar auditorio';
    }
}

function getAudiencie() {
    $.ajax(API, {
        type: 'GET',
        datatype: 'JSON',
        success: function (result) {
            printData(result);
        }
    });
}

function postAudiencie() {
    let Datos = {
        owner: $("#ownerAudience").val(),
        capacity: $("#capacityAudience").val(),
        category_id: $("#categoy_idAudience").val(),
        name: $("#nameAudience").val(),
    };

    let dataToSend = JSON.stringify(Datos);
    $.ajax(API, {
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        // datatype: "JSON",
        success: function (result) {
            clearBoxInput();
            getAudiencie();
        }
    });
}

function getAudiencieById(idClient) {
    $.ajax(API + '/' + idClient, {
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let campo = result.items[0];
            sessionStorage.setItem('id', campo.id);
            $("#ownerAudience").val(campo.owner);
            $("#capacityAudience").val(campo.capacity);
            $("#categoy_idAudience").val(campo.category_id);
            $("#nameAudience").val(campo.name);

            let botonSaUp = document.getElementById('btnSave');

            if (botonSaUp.textContent == 'Guardar auditorio') {
                botonSaUp.textContent = 'Actualizar audiorio';
            }
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function putAudiencie() {
    
    let Datos = {
        id: sessionStorage.getItem('id'),
        owner: $("#ownerAudience").val(),
        capacity: $("#capacityAudience").val(),
        category_id: $("#categoy_idAudience").val(),
        name: $("#nameAudience").val()
    };

    let dataToSend = JSON.stringify(Datos);

    $.ajax(API, {
        data: dataToSend,
        type: 'PUT',
        contentType: 'application/json',
        success: function (result) {
            getAudiencie();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function deleteAudiencieAll() {
    $('input[type=checkbox]:checked').each(function () {
        deleteAudiencie($(this).prop("id"))
    });
}

function deleteAudiencie(idToDelete) {
    let data = { id: idToDelete };
    let dataToSend = JSON.stringify(data);
    $.ajax(API, {
        data: dataToSend,
        type: 'DELETE',
        contentType: 'application/json',
        success: function (result) {
            clearBoxInput();
            getAudiencie();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}
function clearBoxInput() {
    $("#ownerAudience").val("");
    $("#capacityAudience").val("");
    $("#categoy_idAudience").val("");
    $("#nameAudience").val("");
}

function printData(datos) {
    $("#tbclient > tbody > tr").remove();
    let fila = "";
    $.each(datos.items, function (index, campo) {
        fila += "<tr>";
        fila += "<td>" + campo.id + "</td>";
        fila += "<td>" + campo.owner + "</td>";
        fila += "<td>" + campo.capacity + "</td>";
        fila += "<td>" + campo.category_id + "</td>";
        fila += "<td>" + campo.name + "</td>";
        fila += "<td><button  id = 'btn_editar' onclick='getAudiencieById(" + campo.id + ")'></button></td>";
        fila += "<td><input type = 'checkbox' id = " + campo.id + "></td>";
        fila += "</tr>";
    });
    $("#tbclient > tbody").html(fila);
}
