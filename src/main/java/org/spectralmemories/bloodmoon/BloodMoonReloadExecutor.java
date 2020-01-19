package org.spectralmemories.bloodmoon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BloodMoonReloadExecutor implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        LocaleReader localeReader = Bloodmoon.GetInstance().getLocaleReader();
        ConfigReader configReader = Bloodmoon.GetInstance().getConfigReader();

        configReader.RefreshConfigs();
        localeReader.RefreshLocales();

        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            player.sendMessage(localeReader.GetLocaleString("PluginReloaded"));
        }
        return true;
    }
}
