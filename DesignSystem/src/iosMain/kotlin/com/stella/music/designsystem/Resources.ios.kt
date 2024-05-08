package com.stella.music.designsystem

import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.getUIColor

fun getString(stringResource: StringResource): StringDesc {
    return StringDesc.Resource(stringResource)
}

fun getString(stringResource: StringResource, parameter: Any): StringDesc {
    return StringDesc.ResourceFormatted(stringResource, parameter)
}

fun getColor(colorResource: ColorResource) = colorResource.getUIColor()