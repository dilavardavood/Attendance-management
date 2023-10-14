package configs;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

public class DatabaseExecutionContext extends CustomExecutionContext {
    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem, String name) {
        super(actorSystem, "database.dispatcher");
    }

}
