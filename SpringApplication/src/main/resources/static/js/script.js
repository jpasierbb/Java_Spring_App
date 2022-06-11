function successfullyLogout(){
    alert("Zostałeś pomyślnie wylogowany")
}

function confirmDelete(){
    if (confirm("Chcesz usunąć pracownika?")){
        alert("Pracownik został usunięty");
        return true;
    }
    else{
        alert("Pracownik nie został usunięty");
        return false;
    }
}