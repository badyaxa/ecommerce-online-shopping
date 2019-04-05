var mainUrl = "http://localhost/api";
getAllPersons();
setModalConfiguration();
setActionOnCreateBtn();

//start when load page PS reload page for triggered http request

function getAllPersons() {
    $.ajax({
        url: mainUrl + "/brands?page=0&size=10&sortFieldName=id&direction=DESC"
        , type: "GET"
        , contentType: "application/json"
        , success: function (dataResponse) {
            setPersonsToTable(dataResponse.content);
            setActionOnUpdateButtons();
            setActionOnDeleteButtons();
        }
        , error: function (error) {
            alert(error.message);
        }
    });
}

function setPersonsToTable(persons) {
    for (var i = 0; i < persons.length; i++) {
        setPersonToTable(persons[i]);
    }
}

function setPersonToTable(person) {
    var tableOfPersons = $("#persons");
    tableOfPersons.append('<tr>'
        + '<td>' + person.id + '</td>'
        + '<td>' + person.name + '</td>'
        + '<td><button id="openModalup" value="' + person.id + '">Update</button></td>'
        + '<td><button class="button" value="' + person.id + '">Delete</button></td>'
        + '</tr>');
}

//delete process
function setActionOnDeleteButtons() {
    $(".button").each(function (index) {
        $(this).click(function () {
            $.ajax({
                url: mainUrl + "/brands?id=" + $(this).val()
                , type: "DELETE"
                , success: function (data) {
                    location.reload();
                }
                , error: function (error) {
                    alert(error.message);
                }
            });
        })
    })
}

//update process
function setActionOnUpdateButtons() {
    $("#update-button").click(function () {
        var name = $("#fname").val();
        $(this).click(function () {
            $.ajax({
                url: mainUrl + "/brands?id=" + $(this).val()
                , type: "PUT"
                , contentType: "application/json"
                , data: {"name": "eeeeeeeeeee" + $(this).val()}
                , success: function (data) {
                    location.reload();
                }
                , error: function (error) {
                    alert(error.message);
                }
            });
        })
    })
}

function setActionOnCreateBtn() {
    $("#btnCreatePerson").click(function () {
        var name = $("#fname").val();
        //				var lastName = $("#lname").val();
        //				var age = $("#age").val();
        //            if (firstName != null && lastName != null && age != null) {
        var newPerson = {
            "name": name
            //					, "lastName": lastName
            //					, "age": age
        };
        $.ajax({
            url: mainUrl + "/brands"
            , type: "POST"
            , contentType: "application/json"
            , data: JSON.stringify(newPerson)
            , success: function (data) {
                location.reload();
            }
            , error: function (error) {
                alert(error.message);
            }
        });
        //            } else {
        //                alert("Всі поля повинні бути заповнені")
        //            }
    });
}

function setModalConfiguration() {
    // Get the modal
    var modal = document.getElementById('myModal');
    // Get the button that opens the modal
    var btn = document.getElementById("openModal");
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];
    // When the user clicks the button, open the modal
    btn.onclick = function () {
        modal.style.display = "block";
    };
    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    };
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
}
