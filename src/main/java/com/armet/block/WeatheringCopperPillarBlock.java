package com.armet.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperPillarBlock extends RotatedPillarBlock implements WeatheringCopper {
    private final WeatherState weatherState;

    public WeatheringCopperPillarBlock(WeatherState weatherState, Properties properties) {
        super(properties.randomTicks());
        this.weatherState = weatherState;
    }



    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
