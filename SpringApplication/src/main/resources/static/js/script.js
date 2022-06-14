function successfullyLogout(){
    alert("Zostałeś pomyślnie wylogowany")
}

function confirmDelete(){
    if (confirm("Czy na pewno chcesz usunąć?")){
        alert("Rekord został usunięty z bazy danych");
        return true;
    }
    else{
        alert("Nie usunięto rekordu z bazy danych");
        return false;
    }
}