import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum SortingOrder{
    Ascending,
    Descending
}

public class MedicalProfessionsManager {

    private List<MedicalProfession> medicalProfessions = new ArrayList<>();

     static class MedicalProfessionByNameComparator implements Comparator<MedicalProfession>{
        public int compare(@NotNull MedicalProfession f, @NotNull MedicalProfession s){
            return  f.getName().compareTo(s.getName());
        }
    }

    private class MedicalProfessionByAgeComparator implements Comparator<MedicalProfession>{
        public int compare(@NotNull MedicalProfession f, @NotNull MedicalProfession s){
            if(f.getMaxAllowedAge() < s.getMaxAllowedAge()) return -1;
            if(f.getMaxAllowedAge() > s.getMaxAllowedAge()) return 1;
            return 0;
        }
    }

    //static inner class
    public void SortByName(SortingOrder sortingOrder) {
        Collections.sort(medicalProfessions, new MedicalProfessionByNameComparator());
        ReverseCollection(sortingOrder);
    }

    //lambda expr
    public void SortByDepartmentName(SortingOrder sortingOrder) {
        Collections.sort(medicalProfessions, (f, s) -> {
            return f.getDepartmentName().compareTo(s.getDepartmentName());
        });
        ReverseCollection(sortingOrder);
     }

     //inner class
     public void SortByMaxAgeAllowed(SortingOrder sortingOrder){
         Collections.sort(medicalProfessions, new MedicalProfessionByAgeComparator());
         ReverseCollection(sortingOrder);
     }

    //anonymous inner class
    public void SortByShiftDuration(SortingOrder sortingOrder){
        Collections.sort(medicalProfessions, new Comparator<MedicalProfession>(){
            public int compare(MedicalProfession f, MedicalProfession s){
                return Double.compare(f.getShiftDuration(), s.getShiftDuration());
            }
        });
        ReverseCollection(sortingOrder);
    }

    public void CreateTestData(){
         this.medicalProfessions.add(new Ophthalmologist());
        this.medicalProfessions.add(new Obstetrician());
        this.medicalProfessions.add(new Cardiologist());
        this.medicalProfessions.add(new Anesthetist());
        this.medicalProfessions.add(new Epidemiologist());
        this.medicalProfessions.add(new Phoniatr());
        this.medicalProfessions.add(new Pediatrician());
        this.medicalProfessions.add(new Phthisiologist());
        this.medicalProfessions.add(new Urologist());
        this.medicalProfessions.add(new Oncologist());
        this.medicalProfessions.add(new Dermatologist());
        this.medicalProfessions.add(new Therapist());
        this.medicalProfessions.add(new Nurse());
        this.medicalProfessions.add(new Traumatologist());
        this.medicalProfessions.add(new Surgeon());
        this.medicalProfessions.add(new Neurologist());
        this.medicalProfessions.add(new Gynecologist());
        this.medicalProfessions.add(new Radiologist());
        this.medicalProfessions.add(new Psychiatrist());
        this.medicalProfessions.add(new Endocrinologist());
    }

    void Show(){
         for (var prof : medicalProfessions){
             System.out.println(prof);
         }
    }

    private void ReverseCollection(SortingOrder sortingOrder){
        if(sortingOrder == SortingOrder.Descending){
            Collections.reverse(medicalProfessions);
        }
    }

    public void FindByDepartmentName(String depName){
         boolean flag = false;
         for(var prof : medicalProfessions) {
             if(prof.getDepartmentName() == depName){
                 flag = true;
                 System.out.println(prof.name);
             }
        }
         if(!flag){
             System.out.println("За вказаною назвою відділення не вдалося знайти жодної відповідної професії.");
         }
    }

    public void FindByShiftDuration(double shiftDur){
        boolean flag = false;
        for(var prof : medicalProfessions) {
            if(Math.abs(prof.shiftDuration - shiftDur) < 0.000001){
                flag = true;
                System.out.println(prof.name);
            }
        }
        if(!flag){
            System.out.println("За вказаною тривалістю зміни не вдалося знайти жодної відповідної професії.");
        }
    }
}
