package com.example.activate.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.activate.models.CalculoCaloriasForm;
import com.example.activate.models.ContactoForm;
import com.example.activate.models.Noticia;
import com.example.activate.models.Usuario;
import com.example.activate.repositories.ContactoFormRepository;
import com.example.activate.service.CalcularKcalServiceImpl;
import com.example.activate.service.NoticiasServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/activate")
public class MainController {



    @Autowired
    private CalcularKcalServiceImpl calcularKcalService;

    @Autowired
    private UsuarioDBServiceImpl usuarioDBServiceImpl;

     @Autowired
    private ContactoFormRepository contactoFormRepository;

    @Autowired
    private NoticiasServiceImpl noticiasServiceImpl;



 @GetMapping("/inicio")
public String showHome(Model model, Principal principal) {
    if (principal != null) {
        
    }

    List<Noticia> noticias = noticiasServiceImpl.obtenerTodos();

    model.addAttribute("noticias", noticias);
    return "views/index";
}

  

    @GetMapping("/servicios")
    public String showServices() {
        return "views/servicios";
    }

    @GetMapping("/contacto")
    public String showContacto(@ModelAttribute("contactoForm") ContactoForm contactoForm, @RequestParam(required = false) String msg, Model model) {
        if (msg != null && msg.equals("okay")) {
            model.addAttribute("mensajeExito", "Mensaje enviado correctamente.");
        }
        return "forms/contacto";
    }
    

@PostMapping("/contacto/enviar")
public String enviarContacto(@Valid ContactoForm contactoForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
        return "forms/contacto";
    }

    // Obtener el email del usuario autenticado
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && !authentication.getName().equals("anonymousUser")) {
        contactoForm.setEmail(authentication.getName());
    }

    contactoFormRepository.save(contactoForm);
    return "redirect:/activate/contacto?msg=okay";
}


    // Calculo de Calorías
    @GetMapping("servicios/calcularKcal")
    public String showCalcularkcal(Model model) {
        model.addAttribute("calculoCalorias", new CalculoCaloriasForm());
        return "forms/calcularKcal";
    }

   @PostMapping("servicios/calcularKcal")
public String calcularKcal(@ModelAttribute("calculoCalorias") @Valid CalculoCaloriasForm calculoCaloriasForm,
                           BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
        return "forms/calcularKcal";
    }

    // Validación de datos de entrada
    if (calculoCaloriasForm.getEdad() == 0 || calculoCaloriasForm.getPeso() == 0 || calculoCaloriasForm.getAltura() == 0) {
        model.addAttribute("mensajeError", "Por favor, introduzca datos válidos para edad, peso y altura.");
        return "forms/calcularKcal";
    }

    CalcularKcalServiceImpl.Sexo sexo = (calculoCaloriasForm.getSexo().equalsIgnoreCase("HOMBRE"))
            ? CalcularKcalServiceImpl.Sexo.HOMBRE : CalcularKcalServiceImpl.Sexo.MUJER;
    CalcularKcalServiceImpl.NivelActividad nivelActividad = CalcularKcalServiceImpl.NivelActividad.valueOf(calculoCaloriasForm.getNivelActividad());

    double calorias = calcularKcalService.calcularCalorias(sexo, calculoCaloriasForm.getEdad(), calculoCaloriasForm.getPeso(), calculoCaloriasForm.getAltura(), nivelActividad);
    model.addAttribute("calculoCaloriasResultado", String.format("%.2f", calorias));

    return "forms/calcularKcal";
}


    // Iniciar Sesión
    @GetMapping("/iniciarSesion")
    public String showIniciarSesion(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Usuario o contraseña incorrecta.");
        }
        model.addAttribute("usuario", new Usuario());
        return "forms/registrarse";
    }

    @PostMapping("/iniciarSesion/enviar")
    public String showIniciarSesionEnviar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/activate/iniciarSesion?msg=";
        }
        usuarioDBServiceImpl.añadir(usuario);
        return "redirect:/activate/iniciarSesion?msg=okay";
    }

    // Registrarse
    @GetMapping("/registrarse")
    public String showRegistrarse(@RequestParam(required = false) String msg, Model model) {
        if (msg.equals("okay")) {
            model.addAttribute("mensajeCreacion", "Usuario creado correctamente.");
        }else if (msg.equals("error")) {
            model.addAttribute("mensajeCreacion", "Error, campos incorrectos.");           
        }
        model.addAttribute("usuario", new Usuario());
        return "forms/registrarse";
    }

    @PostMapping("/registrarse/enviar")
    public String showRegistrarseEnviar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/activate/registrarse?msg=error";
        }
        usuarioDBServiceImpl.añadir(usuario);
        return "redirect:/activate/registrarse?msg=okay";
    }

    // Cerrar Sesión
    @GetMapping("/cerrarSesion")
    public String showCerrarSesion() {

        return "forms/cerrarSesion";
    }


    // Error
    @GetMapping("/error")
    public String showError() {
        return "views/error";
    }
   
}
