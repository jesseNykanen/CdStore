package hh.palvelinohjelmointi.cdstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.cdstore.model.CategoryRepository;
import hh.palvelinohjelmointi.cdstore.model.Cd;
import hh.palvelinohjelmointi.cdstore.model.CdRepo;

@Controller
public class StoreController {

	@Autowired
	private CdRepo cdRepository;
	@Autowired
	private CategoryRepository categoryrepository;

	@RequestMapping("/")
	public String index() {
		return "redirect:/store";
	}
	
	@RequestMapping("/store")
	public @ResponseBody List<Cd> findCdRest() {
		return (List<Cd>) cdRepository.findAll();
	}

	@RequestMapping("/store/{id}")
	public @ResponseBody Optional<Cd> findCdRest(@PathVariable("id") Long cdId) {
		return cdRepository.findById(cdId);
	}

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String cdStoreController(Model model) {
		model.addAttribute("cds", cdRepository.findAll());
		return "store";
	}

	@RequestMapping(value = "/add")
	public String addCd(Model model) {
		model.addAttribute("cd", new Cd());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addcd";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Cd cd) {
		cdRepository.save(cd);
		return "redirect:store";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCd(@PathVariable("id") Long cdId, Model model) {
		cdRepository.deleteById(cdId);
		return "redirect:../store";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCd(@PathVariable("id") Long cdId, Model model) {
		model.addAttribute("cd", cdRepository.findById(cdId));
		model.addAttribute("categories", categoryrepository.findAll());
		return "editcd";
	}


	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showAlbum(@PathVariable("id") Long cdId, Model model) {
		model.addAttribute("cd", cdRepository.findById(cdId));
		return "showalbum";
	}
}
