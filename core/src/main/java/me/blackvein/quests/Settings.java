/*
 * Copyright (c) 2014 PikaMug and contributors. All rights reserved.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN
 * NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package me.blackvein.quests;

import me.blackvein.quests.config.ISettings;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Settings implements ISettings {
    
    private final Quests plugin;
    private int acceptTimeout = 20;
    private boolean allowCommands = true;
    private boolean allowCommandsForNpcQuests = false;
    private boolean allowPranks = true;
    private boolean clickablePrompts = true;
    private int conditionInterval = 7;
    private boolean confirmAbandon = true;
    private boolean confirmAccept = true;
    private int consoleLogging = 1;
    private boolean disableCommandFeedback = true;
    private boolean genFilesOnJoin = true;
    private boolean giveJournalItem = false;
    private boolean ignoreLockedQuests = false;
    private int killDelay = 0;
    private String language = "en-US";
    private boolean languageOverrideClient;
    private int maxQuests = 0;
    private boolean npcEffects = true;
    private String effect = "note";
    private String redoEffect = "angry_villager";
    private boolean showQuestReqs = true;
    private boolean showQuestTitles = true;
    private int strictPlayerMovement = 0;
    private boolean trialSave = true;
    private int topLimit = 150;
    private boolean translateNames = false;
    private boolean translateSubCommands = false;
    private boolean updateCheck = true;
    private List<String> blockQuests = new ArrayList<>();
    
    public Settings(final Quests plugin) {
        this.plugin = plugin;
    }
    
    public int getAcceptTimeout() {
        return acceptTimeout;
    }
    public void setAcceptTimeout(final int acceptTimeout) {
        this.acceptTimeout = acceptTimeout;
    }
    public boolean canAllowCommands() {
        return allowCommands;
    }
    public void setAllowCommands(final boolean allowCommands) {
        this.allowCommands = allowCommands;
    }
    public boolean canAllowCommandsForNpcQuests() {
        return allowCommandsForNpcQuests;
    }
    public void setAllowCommandsForNpcQuests(final boolean allowCommandsForNpcQuests) {
        this.allowCommandsForNpcQuests = allowCommandsForNpcQuests;
    }
    public boolean canAllowPranks() {
        return allowPranks;
    }
    public void setAllowPranks(final boolean allowPranks) {
        this.allowPranks = allowPranks;
    }
    public boolean canClickablePrompts() {
        return clickablePrompts;
    }
    public void setClickablePrompts(boolean clickablePrompts) {
        this.clickablePrompts = clickablePrompts;
    }
    public int getConditionInterval() {
        return conditionInterval;
    }
    public void setConditionInterval(final int conditionInterval) {
        this.conditionInterval = conditionInterval;
    }
    public boolean canConfirmAbandon() {
        return confirmAbandon;
    }
    public void setConfirmAbandon(final boolean confirmAbandon) {
        this.confirmAbandon = confirmAbandon;
    }
    public boolean canConfirmAccept() {
        return confirmAccept;
    }
    public void setConfirmAccept(final boolean confirmAccept) {
        this.confirmAccept = confirmAccept;
    }
    public int getConsoleLogging() {
        return consoleLogging;
    }
    public void setConsoleLogging(final int consoleLogging) {
        this.consoleLogging = consoleLogging;
    }
    public boolean canDisableCommandFeedback() {
        return disableCommandFeedback;
    }
    public void setDisableCommandFeedback(final boolean disableCommandFeedback) {
        this.disableCommandFeedback = disableCommandFeedback;
    }
    public boolean canGenFilesOnJoin() {
        return genFilesOnJoin;
    }
    public void setGenFilesOnJoin(final boolean genFilesOnJoin) {
        this.genFilesOnJoin = genFilesOnJoin;
    }
    public boolean canGiveJournalItem() {
        return giveJournalItem;
    }
    public void setGiveJournalItem(final boolean giveJournalItem) {
        this.giveJournalItem = giveJournalItem;
    }
    public boolean canIgnoreLockedQuests() {
        return ignoreLockedQuests;
    }
    public void setIgnoreLockedQuests(final boolean ignoreLockedQuests) {
        this.ignoreLockedQuests = ignoreLockedQuests;
    }
    public int getKillDelay() {
        return killDelay;
    }
    public void setKillDelay(final int killDelay) {
        this.killDelay = killDelay;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(final String language) {
        this.language = language;
    }
    public boolean canLanguageOverrideClient() {
        return languageOverrideClient;
    }
    public void setLanguageOverrideClient(final boolean languageOverrideClient) {
        this.languageOverrideClient = languageOverrideClient;
    }
    public int getMaxQuests() {
        return maxQuests;
    }
    public void setMaxQuests(final int maxQuests) {
        this.maxQuests = maxQuests;
    }
    public boolean canNpcEffects() {
        return npcEffects;
    }
    public void setNpcEffects(final boolean npcEffects) {
        this.npcEffects = npcEffects;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(final String effect) {
        this.effect = effect;
    }
    public String getRedoEffect() {
        return redoEffect;
    }
    public void setRedoEffect(final String redoEffect) {
        this.redoEffect = redoEffect;
    }
    public boolean canShowQuestReqs() {
        return showQuestReqs;
    }
    public void setShowQuestReqs(final boolean showQuestReqs) {
        this.showQuestReqs = showQuestReqs;
    }
    public boolean canShowQuestTitles() {
        return showQuestTitles;
    }
    public void setShowQuestTitles(final boolean showQuestTitles) {
        this.showQuestTitles = showQuestTitles;
    }
    public int getStrictPlayerMovement() {
        return strictPlayerMovement;
    }
    public void setStrictPlayerMovement(final int strictPlayerMovement) {
        this.strictPlayerMovement = strictPlayerMovement;
    }
    public boolean canTrialSave() {
        return trialSave;
    }
    public void setTrialSave(final boolean trialSave) {
        this.trialSave = trialSave;
    }
    public int getTopLimit() {
        return topLimit;
    }
    public void setTopLimit(final int topLimit) {
        this.topLimit = topLimit;
    }
    public boolean canTranslateNames() {
        return translateNames;
    }
    public void setTranslateNames(final boolean translateItems) {
        this.translateNames = translateItems;
    }
    public boolean canTranslateSubCommands() {
        return translateSubCommands;
    }
    public void setTranslateSubCommands(final boolean translateSubCommands) {
        this.translateSubCommands = translateSubCommands;
    }
    public boolean canUpdateCheck() {
        return updateCheck;
    }
    public void setUpdateCheck(final boolean updateCheck) {
        this.updateCheck = updateCheck;
    }
    public List<String> getBlockQuests() {
        return blockQuests;
    }
    public void setBlockQuests(final List<String> blockQuests) {
        this.blockQuests = blockQuests;
    }
    
    public void init() {
        final FileConfiguration config = plugin.getConfig();
        acceptTimeout = config.getInt("accept-timeout", 20);
        allowCommands = config.getBoolean("allow-command-questing", true);
        allowCommandsForNpcQuests = config.getBoolean("allow-command-quests-with-npcs", false);
        allowPranks = config.getBoolean("allow-pranks", true);
        clickablePrompts = config.getBoolean("clickable-prompts", true);
        conditionInterval = config.getInt("condition-interval", 8);
        confirmAbandon = config.getBoolean("confirm-abandon", true);
        confirmAccept = config.getBoolean("confirm-accept", true);
        if (conditionInterval < 3 || conditionInterval > 180) {
            plugin.getLogger().warning("Condition interval out of range, reverting to default of 8 seconds");
            conditionInterval = 8;
        }
        consoleLogging = config.getInt("console-logging", 1);
        disableCommandFeedback = config.getBoolean("disable-command-feedback", true);
        genFilesOnJoin = config.getBoolean("generate-files-on-join", true);
        giveJournalItem = config.getBoolean("give-journal-item", false);
        ignoreLockedQuests = config.getBoolean("ignore-locked-quests", false);
        killDelay = config.getInt("kill-delay", 600);
        if (Objects.requireNonNull(config.getString("language")).equalsIgnoreCase("en")) {
            //Legacy
            language = "en-US";
        } else {
            language = config.getString("language", "en-US");
        }
        languageOverrideClient = config.getBoolean("language-override-client", false);
        maxQuests = config.getInt("max-quests", maxQuests);
        npcEffects = config.getBoolean("npc-effects.enabled", true);
        effect = config.getString("npc-effects.new-quest", "note");
        redoEffect = config.getString("npc-effects.redo-quest", "angry_villager");
        showQuestReqs = config.getBoolean("show-requirements", true);
        showQuestTitles = config.getBoolean("show-titles", true);
        strictPlayerMovement = config.getInt("strict-player-movement", 0);
        trialSave = config.getBoolean("trial-save", false);
        topLimit = config.getInt("top-limit", 150);
        translateNames = config.getBoolean("translate-names", true);
        translateSubCommands = config.getBoolean("translate-subcommands", false);
        updateCheck = config.getBoolean("update-check", true);
        blockQuests = config.getStringList("block-quest-take");
        try {
            config.save(new File(plugin.getDataFolder(), "config.yml"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
