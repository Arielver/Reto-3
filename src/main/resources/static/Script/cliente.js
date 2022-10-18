$("document").ready(function () {
    getClient();
});

const API = 'https://g624376352b5710-ogld6oe3ycol328l.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client';

function btnSaveUpdate() {
    let boton1 = document.getElementById('btnSave');

    if (boton1.textContent == 'Guardar cliente') { postClient(); }

    if (boton1.textContent == 'Actualizar cliente') {
        putClient();
        boton1.textContent = 'Guardar cliente';
    }
}

function getClient() {
    $.ajax(API, {
        type: 'GET',
        datatype: 'JSON',
        success: function (result) {
            printData(result);
        }
    });
}

function postClient() {
    let Datos = {
        name: $("#nameClient").val(),
        email: $("#emailClient").val(),
        age: $("#ageClient").val()
    };
    
    let dataToSend = JSON.stringify(Datos);
    $.ajax(API, {
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        // datatype: "JSON",
        success: function (result) {
            clearBoxInput();
            getClient();
            // alert("La información ha sido guardada");
        }
    });
}

function getClientById(idClient) {
    $.ajax(API + '/' + idClient, {
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let campo = result.items[0];
            sessionStorage.setItem('id',campo.id);
            $("#nameClient").val(campo.name);
            $("#emailClient").val(campo.email);
            $("#ageClient").val(campo.age);

            let boton1 = document.getElementById('btnSave');

            if (boton1.textContent == 'Guardar cliente') {
                boton1.textContent = 'Actualizar cliente';
            }
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function putClient() {
    let Datos = {
        id: sessionStorage.getItem('id'),
        name: $("#nameClient").val(),
        email: $("#emailClient").val(),
        age: $("#ageClient").val()
    };

    let dataToSend = JSON.stringify(Datos);

    $.ajax(API, {
        data: dataToSend,
        type: 'PUT',
        contentType: 'application/json',
        success: function (result) {
             //clearBoxInput();
            getClient();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function deleteClientAll (){
    $('input[type=checkbox]:checked').each(function() {
        deleteClient ($(this).prop("id"))
    });
}

function deleteClient(idToDelete) {
            let data = { id: idToDelete };
            let dataToSend = JSON.stringify(data);
            $.ajax(API, {
                data: dataToSend,
                type: 'DELETE',
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
function clearBoxInput() {
            $("#nameClient").val("");
            $("#emailClient").val("");
            $("#ageClient").val("");
            $("#nameClient").focus();
        }

function printData(datos) {
            $("#tbclient > tbody > tr").remove();
            let fila = "";
            $.each(datos.items, function (index, campo) {
                fila += "<tr>";
                fila += "<td>" + campo.id + "</td>";
                fila += "<td>" + campo.name + "</td>";
                fila += "<td>" + campo.email + "</td>";
                fila += "<td>" + campo.age + "</td>";
                fila += "<td><button  id = 'btn_editar' onclick='getClientById(" + campo.id + ")'></button></td>";
                fila += "<td><input type = 'checkbox' id = " + campo.id + "></td>";
                fila += "</tr>";
            });
            $("#tbclient > tbody").html(fila);
        }
