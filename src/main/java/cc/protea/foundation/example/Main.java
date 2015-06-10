package cc.protea.foundation.example;

import cc.protea.foundation.utility.ProfoundConfiguration;
import cc.protea.foundation.utility.ProfoundConfiguration.Storage.Service;
import cc.protea.foundation.utility.ProfoundServer;

public class Main {

	public static void main(final String[] args) throws Exception {

		ProfoundConfiguration.systemEmails.defaultTemplate = "platform-email";
		ProfoundConfiguration.publicUrl = "http://localhost:8080";
		ProfoundConfiguration.servicePackages.add("cc.protea.foundation.template.services");
		ProfoundConfiguration.createSocialAccounts = true;

		ProfoundConfiguration.storage.sessions = Service.REDIS;
		ProfoundConfiguration.storage.users = Service.REDIS;

		ProfoundServer.start();

	}

}
