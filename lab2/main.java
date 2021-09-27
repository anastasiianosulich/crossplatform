
public class main {

    public static void main(String[] args) {
        var professionsManager = new MedicalProfessionsManager();
        professionsManager.CreateTestData();
        professionsManager.SortByShiftDuration(SortingOrder.Descending);
        //professionsManager.Show();
        professionsManager.FindByShiftDuration(9);
    }
}
