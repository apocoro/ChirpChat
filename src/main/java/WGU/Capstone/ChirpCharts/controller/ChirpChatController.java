package WGU.Capstone.ChirpCharts.controller;

import WGU.Capstone.ChirpCharts.dao.ChirpChatRepository;
import WGU.Capstone.ChirpCharts.entity.ChirpChat;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/chirpChat")

public class ChirpChatController {

    private final ChirpChatRepository chirpChatRepository;

    public ChirpChatController(ChirpChatRepository chirpChatRepository) {
        this.chirpChatRepository = chirpChatRepository;
    }

    //Get all chat logs for a team and year
    @GetMapping("/chat-logs")
    public List<ChirpChat> getChatLogs(@RequestParam Integer franchiseId, @RequestParam Integer year) {
        return chirpChatRepository.getChatsByTeamAndYear(franchiseId, year);
    }

    //Create new message
    @PostMapping
    public ChirpChat createMessage(@RequestBody ChirpChat chat) {
        return chirpChatRepository.save(chat);
    }

    //Update message by id
    @PutMapping("/{id}")
    public ChirpChat updateMessage(
            @PathVariable Integer id,
            @RequestBody ChirpChat chat) {

        chat.setId(id);
        return chirpChatRepository.save(chat);
    }

    //Delete message by id
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Integer id) {
        chirpChatRepository.deleteById(id);
    }

}
