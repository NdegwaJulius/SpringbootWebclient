package WEBCLIENT.demo;

import WEBCLIENT.demo.rest.User;
import org.springframework.stereotype.Service;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UsersService {

    private final WebClient webclient;
    private final CompositeUriComponentsContributor uri;

    public UsersService(WebClient.Builder builder, CompositeUriComponentsContributor uri) {
      webclient=  builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
        this.uri = uri;
    }


    public  User[] getUsers() {
        String s = "/users";
        return webclient
                .get()
                .uri(s)
                .retrieve()
                .bodyToMono(User[].class)
                .block();

    }
}
