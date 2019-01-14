/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonnect.slackbot.bot;

import me.ramswaroop.jbot.core.common.Controller;
import me.ramswaroop.jbot.core.common.EventType;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import static me.ramswaroop.jbot.core.common.EventType.DIRECT_MENTION;

@Component
public class SlackBot extends Bot {
    private Map<Integer, String> jokes = new HashMap<>();


    private static final Logger logger = LoggerFactory.getLogger(SlackBot.class);

    @Value("${slackBotToken}")
    private String slackToken;

    @Override
    public String getSlackToken() {
        return slackToken;
    }

    @Override
    public Bot getSlackBot() {
        return this;
    }

    @Controller(events = {DIRECT_MENTION, EventType.DIRECT_MESSAGE})
    public void onReceiveDM(WebSocketSession session, Event event) {
        reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName()));
    }

    @Controller(events = EventType.MESSAGE, pattern = "joke")
    public void onReceiveMessage(WebSocketSession session, Event event, Matcher matcher) {
        if (!matcher.group(0).isEmpty()) {

            reply(session, event, new Message(jokes.get((int) (Math.random() * (32 - 0)) + 0)));
        } else {

            reply(session, event, new Message("Gonnect is training me!!! Soon I will understand you. Appolgises!!!"));
        }
    }



    @PostConstruct
    public void postConstruct() {
        jokes.put(1, "Today at the bank, an old lady asked me to help check her balance. So I pushed her over.");
        jokes.put(2, "I bought some shoes from a drug dealer. I don't know what he laced them with, but I've been tripping all day.");
        jokes.put(3, "I told my girlfriend she drew her eyebrows too high. She seemed surprised.");
        jokes.put(4, "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.");
        jokes.put(5, "I'm so good at sleeping. I can do it with my eyes closed.");
        jokes.put(6, "My boss told me to have a good day.. so I went home.");
        jokes.put(7, "Why is Peter Pan always flying? He neverlands.");
        jokes.put(8, "A woman walks into a library and asked if they had any books about paranoia. The librarian says \"They're right behind you!\"");
        jokes.put(9, "The other day, my wife asked me to pass her lipstick but I accidentally passed her a glue stick. She still isn't talking to me.");
        jokes.put(10, "Why do blind people hate skydiving? It scares the hell out of their dogs.");
        jokes.put(11, "When you look really closely, all mirrors look like eyeballs.");
        jokes.put(12, "My friend says to me: \"What rhymes with orange\" I said: \"No it doesn't\"");
        jokes.put(13, "What do you call a guy with a rubber toe? Roberto.");
        jokes.put(14, "What did the pirate say when he turned 80 years old? Aye matey.");
        jokes.put(15, "My wife told me I had to stop acting like a flamingo. So I had to put my foot down.");
        jokes.put(16, "I couldn't figure out why the baseball kept getting larger. Then it hit me.");
        jokes.put(17, "Why did the old man fall in the well? Because he couldn't see that well.");
        jokes.put(18, "I ate a clock yesterday, it was very time consuming.");
        jokes.put(19, "A blind man walks into a bar. And a table. And a chair.");
        jokes.put(20, "I know a lot of jokes about unemployed people but none of them work.");
        jokes.put(21, "What's orange and sounds like a parrot? A carrot.");
        jokes.put(22, "Did you hear about the italian chef that died? He pasta way.");
        jokes.put(23, "Why couldn't the bicycle stand up? Because it was two tired!");
        jokes.put(24, "Parallel lines have so much in common. It’s a shame they’ll never meet.");
        jokes.put(25, "When a deaf person sees someone yawn do they think it’s a scream?");
        jokes.put(26, "As I suspected, someone has been adding soil to my garden. The plot thickens.");
        jokes.put(27, "How do crazy people go through the forest? They take the physco path.");
        jokes.put(28, "And the lord said unto John, \"Come forth and you will receive eternal life\". John came fifth and won a toaster.");
        jokes.put(29, "What did the traffic light say to the car? Don’t look! I’m about to change.");
        jokes.put(30, "I just wrote a book on reverse psychology. Do *not* read it!");
        jokes.put(31, "What did one hat say to the other? You stay here. I’ll go on ahead.");
        jokes.put(32, "Why wouldn’t the shrimp share his treasure? Because he was a little shellfish.");
        ;
    }
}
