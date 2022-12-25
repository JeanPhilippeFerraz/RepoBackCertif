package com.easychat.core.mapper;

import com.easychat.core.Controller.dto.ChannelDto;
import com.easychat.core.entity.Channel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Bean
//@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
//@Mapper(componentModel = "spring")
public class ChannelMapper {

    //@Mapping
    public ChannelDto mapChannelToChannelDto(Channel channel){
        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(channel.getId());
        channelDto.setDescription(channel.getDescription());
        channelDto.setName(channel.getName());
        channelDto.setCreated_at(channel.getCreated_at());
        channelDto.setUpdated_at(channel.getUpdated_at());

        return channelDto;
    }

    //@Mapping
    public Channel mapChannelDtoToChannel(ChannelDto channelDto){
        Channel channel = new Channel();
        channel.setId(channelDto.getId());
        channel.setName(channelDto.getName());
        channel.setDescription(channelDto.getDescription());

        return channel;
    }
}
