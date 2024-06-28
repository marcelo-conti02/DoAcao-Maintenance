import { useMemo } from "react";

const useLocalStorage = () => {
    const getLocalStorageItem = async (key) => {
        return await JSON.parse(localStorage.getItem(key))
    }

    const setLocalStorageItem = (key, value) => {
        localStorage.setItem(key, JSON.stringify(value))
    }

    const removeLocalStorageItem = (key) => {
        localStorage.removeItem(key)
    }

    return useMemo(() => ({
        getLocalStorageItem,
        setLocalStorageItem,
        removeLocalStorageItem,
    }), [])
}

export { useLocalStorage };