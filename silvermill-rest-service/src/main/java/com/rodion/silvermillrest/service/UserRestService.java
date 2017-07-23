package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.UserClient;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermillrest.mapper.UserModelMapper;
import com.rodion.silvermillrest.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Rodion
 */


@RestController("userRestService")
//@Api(value = "viewRestService-docs", description = "USER REST Service endpoint.")
@RequestMapping("/user")
public class UserRestService {


    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);
    private final UserClient userClient;

    public UserRestService(UserClient userClient) {
        this.userClient = Objects.requireNonNull(userClient, "userClient cannot be null");
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser(@PathVariable String username){

        User user = userClient.findUserByUsername(username);
        UserModel userModel = UserModelMapper.map(user);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUsers(){
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserModel> createUser(){
        return null;
    }
    /*

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseModel> getPerson(@RequestHeader(HeaderNames.IV_USER) String ssn,
                                                   @RequestHeader(HeaderNames.AUTH_METHOD) AuthenticationMethod method) {
        Optional<Person> personOptional = personClient.getPerson(ssn);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            ResponseModel model = ResponseModel.builder()
                    .withAsync(false)
                    .withHasErrors(false)
                    .withData(PersonModelMapper.map(person, method))
                    .build();
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            Optional<String> channelId = personClient.loadPersonData(LoadPersonRequest.builder().withSsn(ssn).build());
            if (channelId.isPresent()) {
                String cometdChannelId = personCometdService.getChannelId(channelId.get());
                personCometdService.createChannel(cometdChannelId);
                ResponseModel model = ResponseModel.builder()
                        .withAsync(true)
                        .withServer("/cometd")
                        .withChannel(cometdChannelId)
                        .build();
                return new ResponseEntity<>(model, HttpStatus.OK);
            }
            throw new ExternalServiceException("Could not load Person name data");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(@RequestHeader(HeaderNames.IV_USER) String ssn,
                               @CookieValue(value = "IV_JCT", required = false) String authMethod) {
        Boolean eLegAuthorized = Boolean.FALSE;
        if (authMethod != null) {
            eLegAuthorized = Boolean.TRUE;
        }

        LOGGER.info("User eLeg auhtenticated {}", eLegAuthorized);

        ssn = personalIdentityNumberFormatter.formatPnrTo(ssn, PnrFormat.PERSON_ID_NO_SEPARATOR);

        LogoutMessage logoutMessage = logoutMessageBuilder
                .withStatus(MessageStatus.UNHANDLED)
                .withLogoutId(ssn)
                .build();
        publisher.publish(logoutMessage);

        String logoutUrl = personClient.getLogoutUrl(ssn, eLegAuthorized);
        return new ModelAndView(logoutUrl, new ModelMap());
    }

    @RequestMapping(value = "/preferred/phone/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseModel> setPreferredPhoneNumber(@RequestHeader(HeaderNames.IV_USER) String ssn,
                                                                 @PathVariable String id) {


        Optional<String> eventOptional = personClient.updatePreferredPhoneNumber(UpdatePersonPreferredPhoneNumberRequest.builder().withSsn(ssn).withPhoneNumberId(id).build());

        return eventResponse(eventOptional);
    }

    @RequestMapping(value = "/preferred/mail/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseModel> setPreferredEmail(@RequestHeader(HeaderNames.IV_USER) String ssn,
                                                           @PathVariable String id) {

        Optional<String> eventOptional = personClient.updatePreferredEmailAddress(UpdatePersonPreferredEmailAddressRequest.builder().withSsn(ssn).withEmailAddressId(id).build());
        return eventResponse(eventOptional);

    }

    @RequestMapping(value = "/contactinfo", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseModel> updatePersonContactInfo(
            @RequestHeader(HeaderNames.IV_USER) String ssn,
            @RequestBody PersonModel personModel) {

        //@TODO Change to map to request uinstead
        UpdatePersonContactInfoRequest request = PersonModelMapper.map(personModel,ssn);
        Optional<String> eventOptional = personClient.updatePersonContactInfo(request);

        return eventResponse(eventOptional);
    }

    @RequestMapping(value = "/password/sms/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseModel> updateSmsPasswordNumber(@RequestHeader(HeaderNames.IV_USER) String ssn,
                                                                 @PathVariable String id) {
        Optional<String> eventOptional = personClient.updateSmsPasswordNumber(
                UpdatePersonSmsPasswordRequest.builder().withSsn(ssn).withPhoneNumberId(id).build());
        return eventResponse(eventOptional);
    }

    private ResponseEntity<ResponseModel> eventResponse(Optional<String> eventOptional) {
        if (!eventOptional.isPresent()) {
            ResponseModel model = ResponseModel.builder()
                    .withAsync(false)
                    .withHasErrors(true)
                    .withData(null)
                    .build();
            return new ResponseEntity<>(model, HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            String cometdChannelId = personCometdService.getChannelId(eventOptional.get());
            personCometdService.createChannel(cometdChannelId);
            ResponseModel model = ResponseModel.builder()
                    .withAsync(true)
                    .withServer("/cometd")
                    .withChannel(cometdChannelId)
                    .build();
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }
 */
}
