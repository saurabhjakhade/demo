package com.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ChatException;
import com.example.model.ChatMessage;
import com.example.model.ToDo;
import com.example.service.ToDoService;
import com.example.util.ChatJavaClient;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@RestController
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	private ToDoService toDoService;
	
	
	Map context=new HashMap();
	
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getAllToDo(){
    	logger.info("Returning all the ToDo´s");
		return new ResponseEntity<List<ToDo>>(toDoService.getAllToDo(), HttpStatus.OK);
	}
	
   
    
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
   	public ResponseEntity<ChatMessage> processChat(@RequestBody ChatMessage payload) throws ChatException{
    	logger.info("Payload to send " + payload);
    /*	if (!PayloadValidator.validateCreatePayload(payload)){
            throw new ToDoException("Payload malformed, id must not be defined");
    	}*/
    	MessageResponse res=ChatJavaClient.getResponse(context, payload.getText());
    	context=res.getContext();
    	StringBuilder resText=new StringBuilder();
    	res.getText().forEach(message->resText.append(message));
    	payload.setText(resText.toString());
		return new ResponseEntity<ChatMessage>(payload, HttpStatus.OK);
   	}
    
   
}
