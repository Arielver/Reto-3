$("document").ready(function () {
    getMessage();
});

const API = 'https://g624376352b5710-ogld6oe3ycol328l.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message';

function btnSaveUpdate() {
    let botonSaUp = document.getElementById('btnSave');

    if (botonSaUp.textContent == 'Guardar mensaje') { postMessage(); }

    if (botonSaUp.textContent == 'Actualizar mensaje') {
        putMessage();
        botonSaUp.textContent = 'Guardar mensaje';
    }
}

function getMessage() {
    $.ajax(API, {
        type: 'GET',
        datatype: 'JSON',
        success: function (result) {
            printData(result);
        }
    });
}

function postMessage() {
    alert ("Este es el mensaje a guardar: " +  '$("#messageText").val()');
    let Datos = {
        messagetext: $("#messageText").val()
    };
    let dataToSend = JSON.stringify(Datos);
   
    $.ajax(API, {
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        datatype: 'JSON',
        success: function (result) {
            clearBoxInput();
            getMessage();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function getMessageById(idmessageText) {
    $.ajax(API + '/' + idmessageText, {
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let campo = result.items[0];
            sessionStorage.setItem('id',campo.id);
            $("#messageText").val(campo.messagetext);

            let botonSaUp = document.getElementById('btnSave');

            if (botonSaUp.textContent == 'Guardar mensaje') {
                botonSaUp.textContent = 'Actualizar mensaje';
            }
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function putMessage() {
    let Datos = {
        id: sessionStorage.getItem('id'),
        messagetext: $("#messageText").val(),
    };
    
    let dataToSend = JSON.stringify(Datos);

    $.ajax(API, {
        data: dataToSend,
        type: 'PUT',
        contentType: 'application/json',
        success: function (result) {
            clearBoxInput();
            getClient();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function deleteMessageAll (){
    $('input[type=checkbox]:checked').each(function() {
        deleteMessage ($(this).prop("id"))
    });
}

function deleteMessage(idToDelete) {
            let data = { id: idToDelete };
            let dataToSend = JSON.stringify(data);
            $.ajax(API, {
                data: dataToSend,
                type: 'DELETE',
                contentType: 'application/json',
                success: function (result) {
                    clearBoxInput();
                    getMessage();
                },
                error: function (xhr, status) {
                    alert('ha sucedido un problema');
                }
            });
        }
function clearBoxInput() {
            $("#messageText").val("");
        }

function printData(datos) {
            $("#tbclient > tbody > tr").remove();
            let fila = "";
            $.each(datos.items, function (index, campo) {
                fila += "<tr>";
                fila += "<td>" + campo.id + "</td>";
                fila += "<td><p>" + campo.messagetext + "</p></td>";
                fila += "<td><button  id = 'btn_editar' onclick='getMessageById(" + campo.id + ")'></button></td>";
                fila += "<td><input type = 'checkbox' id = " + campo.id + "></td>";
                fila += "</tr>";
            });
            $("#tbclient > tbody").html(fila);
        }
