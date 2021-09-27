public abstract class MedicalProfession {
    protected String name;
    double shiftDuration;
    String departmentName;
    private int maxAllowedAge;

    public MedicalProfession(String name, double shiftDuration, String departmentName, int maxAllowedAge){
        this.name = name;
        this.shiftDuration = shiftDuration;
        this.departmentName = departmentName;
        this.maxAllowedAge = maxAllowedAge;
    }

    public int getMaxAllowedAge(){
        return maxAllowedAge;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public double getShiftDuration(){
        return shiftDuration;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "MedicalProfession{" +
                "name='" + name + '\'' +
                ", shiftDuration=" + shiftDuration +
                ", departmentName='" + departmentName + '\'' +
                ", maxAllowedAge=" + maxAllowedAge +
                '}';
    }
}

class Obstetrician extends MedicalProfession{
    public Obstetrician(){
        super("Акушер", 12, "Гінекологічне", 62);
    }
}
class Anesthetist extends MedicalProfession{
    public Anesthetist(){
        super("Анестезіолог", 8.5, "Анестезіології", 55);
    }
}

class Cardiologist extends MedicalProfession{
    public Cardiologist(){
        super("Кардіолог", 8, "Кардіології", 60);
    }
}

class Phthisiologist extends MedicalProfession{
    public Phthisiologist(){
        super("Фтизіатр", 9, "Протитуберкульозне", 55);
    }
}

class Epidemiologist extends MedicalProfession{
    public Epidemiologist(){
        super("Епідеміолог", 9, "Епідеміології", 56);
    }
}

class Pediatrician extends MedicalProfession{
    public Pediatrician(){
        super("Педіатр", 8, "Педіатрії", 60);
    }
}

class Surgeon extends MedicalProfession{
    public Surgeon(){
        super("Хірург", 8.5, "Хірургічне", 68);
    }
}

class Urologist extends MedicalProfession{
    public Urologist(){
        super("Уролог", 8, "Урології", 55);
    }
}

class Phoniatr extends MedicalProfession{
    public Phoniatr(){
        super("Фоніатр", 7.5, "Отоларингологічне", 60);
    }
}
class Dermatologist extends MedicalProfession{
    public Dermatologist(){
        super("Дерматолог", 9, "Дерматологічне", 55);
    }
}
class Radiologist extends MedicalProfession{
    public Radiologist(){
        super("Радіолог", 8.5, "Радіологічне", 60);
    }
}
class Therapist extends MedicalProfession{
    public Therapist(){
        super("Терапевт", 9.5, "Терапевтичне", 58);
    }
}
class Nurse extends MedicalProfession{
    public Nurse(){
        super("Медсестра", 10, "", 58);
    }
}
class Ophthalmologist extends MedicalProfession{
    public Ophthalmologist(){
        super("Офтальмолог", 9, "Офтальмологічне", 55);
    }
}
class Traumatologist extends MedicalProfession{
    public Traumatologist(){
        super("Травматолог", 9, "Травматології", 58);
    }
}
class Gynecologist extends MedicalProfession{
    public Gynecologist(){
        super("Гінеколог", 9, "Гінекологічне", 55);
    }
}
class Neurologist extends MedicalProfession{
    public Neurologist(){
        super("Невролог", 7.5, "Неврологічне", 58);
    }
}
class Oncologist extends MedicalProfession{
    public Oncologist(){
        super("Онколог", 9, "Онкології", 60);
    }
}
class Psychiatrist extends MedicalProfession{
    public Psychiatrist(){
        super("Психіатр", 8.5, "Психіатрії", 55);
    }
}
class Dentist extends MedicalProfession{
    public Dentist(){
        super("Стоматолог", 10.5, "Стоматологічне", 58);
    }
}
class Endocrinologist extends MedicalProfession{
    public Endocrinologist(){
        super("Ендокринолог", 8.5, "Ендокринології", 60);
    }
}