$("document").ready(function () {
    getCategory();
});

function btnSaveUpdate() {
    let botonSaUp = document.getElementById('btnSave');

    if (botonSaUp.textContent == 'Guardar auditorio') { postCategory(); }

    if (botonSaUp.textContent == 'Actualizar audiorio') {
        
        putCategory();
        botonSaUp.textContent = 'Guardar auditorio';
    }
}

function getCategory() {
    $.ajax({
        url: "../api/Category/all",
        datatype: 'JSON',
        type: 'GET',
        success: function (result) {
            printData(result);
        }
    });
}

function postCategory() {
    let Datos = {
        name: $("#nameCategory").val(),
        description: $("#descriptionCategory").val(),
    };

    let dataToSend = JSON.stringify(Datos);
    $.ajax({
        url: "../api/Category/save",
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

function getCategoryById(idClient) {
    $.ajax({
        url: "../api/Category/"+ idClient,
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

function putCategory() {
    let Datos = {
        id: sessionStorage.getItem('id'),
        name: $("#nameCategory").val(),
        description: $("#descriptionCategory").val(),
    };

    let dataToSend = JSON.stringify(Datos);

    $.ajax({
        url: "api/Category/update",
        // data: dataToSend,
        contentType: 'application/json',
        type: 'PUT',
        success: function (result) {
            getAudiencie();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function deleteCategoryAll() {
    $('input[type=checkbox]:checked').each(function () {
        deleteCategory($(this).prop("id"))
    });
}

function deleteCategory(idToDelete) {
    // let data = { id: idToDelete };
    // let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "api/Category/" + idToDelete,
        // data: dataToSend,
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
    $("#nameCategory").val("");
    $("#descriptionCategory").val("");
}

function printData(datos) {
    $("#tbcategory > tbody > tr").remove();
    let fila = "";
    console.log(datos);
    $.each(datos.items, function (index, campo) {
        fila += "<tr>";
        fila += "<td>" + campo.id + "</td>";
        fila += "<td>" + campo.name + "</td>";
        fila += "<td>" + campo.description + "</td>";
        fila += "<td><button  id = 'btn_editar' onclick='getCategoryById(" + campo.id + ")'></button></td>";
        fila += "<td><input type = 'checkbox' id = " + campo.id + "></td>";
        fila += "</tr>";
    });
    $("#tbcategory > tbody").html(fila);
}
