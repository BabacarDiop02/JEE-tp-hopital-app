package diop.babacar.hopitalapp.web;

import diop.babacar.hopitalapp.entities.Patient;
import diop.babacar.hopitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index (Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("listPatients", patients);
        return "patients";
    }

    @GetMapping("/deletePatient")
    public String deletePatient (@RequestParam(name = "id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/index";
    }
}
