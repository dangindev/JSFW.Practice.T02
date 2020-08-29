$(function () {
    $(".header").load("header.html");
    $(".menu").load("menu.html");
    $(".footer").load("footer.html");
    $(".content").load("home.html");
});

function clickHomeButton() {
    $(".content").load("home.html");
}

function clickAddButton() {
    $(".content").load("car.html");
    $("#saveCarForm").trigger("reset");
    $('#plicensePlate').text('');
    $('#prepairDate').text('');
}

function clickSaveCarBtn() {
    let car = {
        licensePlate: $("#licensePlate").val(),
        stringRepairDate: $("#repairDate").val(),
        customerName: $("#customerName").val(),
        catalogs: $("#catalogs").val(),
        carMaker: $("#carMaker").val()
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/cars',
        type: 'POST',
        data: JSON.stringify(car), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            showSuccessAlert();
            showAccessoryDetailBtn();
            $('#plicensePlate').text(car.licensePlate);
            $('#prepairDate').text(car.stringRepairDate);
            $("#saveCarForm").trigger("reset");
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}

function showAccessoryDetailBtn() {
    $('#accessoryDetailBtn').show();
}

function clickAccessoryDetailBtn() {
    let licensePlate = $('#plicensePlate').text();
    let repairDate = $('#prepairDate').text();
    $(".content").load("accessoryDetail.html");
    setTimeout(() => {
        buildAccessoryDetail(licensePlate, repairDate);
    }, 500);
}
function buildAccessoryDetail(licensePlate, repairDate) {
    $('#lilicensePlate').text(licensePlate);
    $('#lirepairDate').text(repairDate);
    $("#saveAccessoriesForm").trigger("reset");

    $.get(`http://localhost:8080/api/v1/cars/${licensePlate}_${repairDate}/accessories`, function (data, status) {

        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        // success
        // empty table before rebuild it
        $('tbody').empty();

        accessories = data;
        fillCarAccessories(accessories);
    });
}

function fillCarAccessories(accessories, licensePlate, repairDate) {
    let count = 0;
    accessories.forEach(function (accessory) {
        $('tbody').append(
            `<tr>
            <td> ${++count}</td>
            <td> ${accessory.name}</td>
            <td> ${accessory.price}</td>
            <td> ${accessory.statusDamaged}</td>
            <td> ${accessory.repairStatus}</td>
            <td><a class="edit" title="Edit" data-toggle="tooltip" onclick="clickUpdateBtn(${accessory.id})"><i class="material-icons">&#xE254;</i></a>
            <a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(${accessory.id})"><i class="material-icons">&#xE872;</i></a></td>
            </tr>`)
    });
}

function clickSaveAccessoryBtn() {
    let id=$("#id").val();
    if(id){
        updateAccessory(id);
    }
    else{
        addCarAccessory();
    }
    
}
function addCarAccessory() {
    let licensePlate = $('#lilicensePlate').text();
    let repairDate = $('#lirepairDate').text();
    let accessory = {
        name: $("#name").val(),
        price: $("#price").val(),
        statusDamaged: $("#statusDamaged").val(),
        repairStatus: $("#repairStatus").val(),
    }
    $.ajax({
        url: `http://localhost:8080/api/v1/cars/${licensePlate}_${repairDate}/accessories`,
        type: 'POST',
        data: JSON.stringify(accessory), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            showSuccessAlert();
            showAccessoryDetailBtn();
            buildAccessoryDetail(licensePlate, repairDate);
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function openConfirmDelete(id) {
    let licensePlate = $('#lilicensePlate').text();
    let repairDate = $('#lirepairDate').text();
    let result = confirm("Do you want to delete this accessory?");
    if (result) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/accessories/' + id,
            type: 'DELETE',
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                buildAccessoryDetail(licensePlate, repairDate);
            }
        });
    }
}

function clickUpdateBtn(id) {
    fillDataToForm(id);
}

function fillDataToForm(id) {
    $.get(`http://localhost:8080/api/v1/accessories/${id}`, function (data, status) {

        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        // success
        accessory = data;
        console.log(accessory);
        $("#id").val(accessory.id);
        $("#name").val(accessory.name);
        $("#price").val(accessory.price);
        $("#statusDamaged").val(accessory.statusDamaged);
        $("#repairStatus").val(accessory.repairStatus);
    });
}

function updateAccessory(id) {
    let licensePlate = $('#lilicensePlate').text();
    let repairDate = $('#lirepairDate').text();
    let accessory = {
        name: $("#name").val(),
        price: $("#price").val(),
        statusDamaged: $("#statusDamaged").val(),
        repairStatus: $("#repairStatus").val(),
    }
    $.ajax({
        url: `http://localhost:8080/api/v1/accessories/${id}`,
        type: 'PUT',
        data: JSON.stringify(accessory),
        contentType: "application/json",
        success: function (result) {
            // success
            showSuccessAlert()
            buildAccessoryDetail(licensePlate, repairDate);
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}








